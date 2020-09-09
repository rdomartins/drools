package br.com.drools.corrida.listener;

import org.kie.api.event.rule.ObjectDeletedEvent;
import org.kie.api.event.rule.ObjectInsertedEvent;
import org.kie.api.event.rule.ObjectUpdatedEvent;
import org.kie.api.event.rule.RuleRuntimeEventListener;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class CorridaRuleEventListener
    implements RuleRuntimeEventListener {

    private static final Logger logger =
            LoggerFactory.getLogger(CorridaRuleEventListener.class);

    @Override
    public void objectInserted(ObjectInsertedEvent event) {
        logger.info(event.getClass().getSimpleName() );
        System.out.println( event.getRule());
    }

    @Override
    public void objectUpdated(ObjectUpdatedEvent event) {
        logger.info(event.getClass().getSimpleName() );
        System.out.println( event.getRule());
    }

    @Override
    public void objectDeleted(ObjectDeletedEvent event) {
        logger.info(event.getClass().getSimpleName() );
        System.out.println( event.getRule());
    }
}