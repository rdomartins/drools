package br.com.drools.corrida;

import br.com.drools.corrida.listener.CorridaAgendaEventListener;
import br.com.drools.corrida.listener.CorridaProcessEventListener;
import br.com.drools.corrida.listener.CorridaRuleEventListener;
import br.com.drools.corrida.service.Provider;
import org.kie.api.KieServices;
import org.kie.api.builder.*;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;
import org.kie.internal.io.ResourceFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan("br.com.drools.corrida")
public class CorridaConfiguration {
    private static final String DRL_FILE = "CORRIDA_RULE.drl";
    private static final String DT_FILE = "rules/CORRIDA_RULE.xls";

    @Autowired
    @Qualifier("drlContainer")
    private KieContainer drlContainer;

    @Autowired
    @Qualifier("dtContainer")
    private KieContainer dtContainer;

    @Bean("drlSession")
    public Provider<KieSession> drlSession() {
        return () -> {
            return createKieSession(drlContainer);
        };
    }

    @Bean("dtSession")
    public Provider<KieSession> dtSession() {
        return () -> {
            return createKieSession(dtContainer);
        };
    }

    private KieSession createKieSession(KieContainer drlContainer) {
        KieSession kieSession = drlContainer.newKieSession();
        kieSession.addEventListener(new CorridaAgendaEventListener());
        kieSession.addEventListener(new CorridaProcessEventListener());
        kieSession.addEventListener(new CorridaRuleEventListener());
        return kieSession;
    }

    @Bean("drlContainer")
    public KieContainer drlContainer() {
        return createKieContainer(DRL_FILE);
    }

    @Bean("dtContainer")
    public KieContainer dtContainer() {
        /* [rodrigo.martins essa e uma outra forma de carregar a decision table para memoria]
        KieServices ks = KieServices.Factory.get();
        KieContainer kContainer = ks.getKieClasspathContainer();
        KieSession kieSession = kContainer.newKieSession("ksession-rule");
        */
        return createKieContainer(DT_FILE);
    }

    private KieContainer createKieContainer(String file) {
        KieServices kieServices = KieServices.Factory.get();

        KieFileSystem kieFileSystem = kieServices.newKieFileSystem();
        kieFileSystem.write(ResourceFactory.newClassPathResource(file));
        KieBuilder kieBuilder = kieServices.newKieBuilder(kieFileSystem);
        kieBuilder.buildAll();

        KieModule kieModule = kieBuilder.getKieModule();
        return kieServices.newKieContainer(kieModule.getReleaseId());
    }

}