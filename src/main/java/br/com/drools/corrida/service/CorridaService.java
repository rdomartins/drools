package br.com.drools.corrida.service;

import br.com.drools.corrida.model.Corrida;
import br.com.drools.corrida.model.Tarifa;
import org.kie.api.runtime.KieSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
public class CorridaService {

    @Autowired
    @Qualifier("drlSession")
    private Provider<KieSession> drlSessionProvider;

    @Autowired
    @Qualifier("dtSession")
    private Provider<KieSession> dtSessionProvider;

    public Tarifa calcularDRL(Corrida corrida) {
        Tarifa tarifa = new Tarifa();

        KieSession drlSession = drlSessionProvider.get();
        drlSession.setGlobal("tarifa", tarifa);
        drlSession.insert(corrida);
        drlSession.fireAllRules();
        drlSession.dispose();
        return tarifa;
    }

    public Tarifa calcularDT(Corrida corrida) {
        Tarifa tarifa = new Tarifa();
        KieSession kieSession = dtSessionProvider.get();
        kieSession.setGlobal("tarifa", tarifa);
        kieSession.insert(corrida);
        kieSession.fireAllRules();
        kieSession.dispose();
        return tarifa;
    }

}
