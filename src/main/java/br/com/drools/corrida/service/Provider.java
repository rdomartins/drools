package br.com.drools.corrida.service;

@FunctionalInterface
public interface Provider<KieSession> {
    public KieSession get();
}

