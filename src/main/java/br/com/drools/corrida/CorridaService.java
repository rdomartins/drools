package br.com.drools.corrida;

import br.com.drools.corrida.listener.CorridaAgendaEventListener;
import br.com.drools.corrida.listener.CorridaProcessEventListener;
import br.com.drools.corrida.listener.CorridaRuleEventListener;
import org.kie.api.KieServices;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CorridaService {
 
    @Autowired
    private KieContainer kieContainer;

    public Tarifa calcularDRL(Corrida corrida) {
        Tarifa tarifa = new Tarifa();
        KieSession kieSession = kieContainer.newKieSession();
        kieSession.addEventListener(new CorridaAgendaEventListener());
        kieSession.addEventListener(new CorridaProcessEventListener());
        kieSession.addEventListener(new CorridaRuleEventListener());
        kieSession.setGlobal("tarifa", tarifa);
        kieSession.insert(corrida);
        kieSession.fireAllRules();
        kieSession.dispose();
        return tarifa;
    }

    public Tarifa calcularDT(Corrida corrida) {
        Tarifa tarifa = new Tarifa();
        KieServices ks = KieServices.Factory.get();
        KieContainer kContainer = ks.getKieClasspathContainer();
        KieSession kieSession = kContainer.newKieSession("ksession-rule");
        kieSession.setGlobal("tarifa", tarifa);
        kieSession.insert(corrida);
        kieSession.fireAllRules();
        kieSession.dispose();
        return tarifa;
    }

}