package br.com.drools.corrida.listener;

import org.kie.api.event.process.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class CorridaProcessEventListener
    implements org.kie.api.event.process.ProcessEventListener {

    private static final Logger logger =
            LoggerFactory.getLogger(CorridaProcessEventListener.class);

    @Override
    public void beforeProcessStarted(ProcessStartedEvent event) {
        logger.info(event.getClass().getSimpleName() );
    }

    @Override
    public void afterProcessStarted(ProcessStartedEvent event) {
        logger.info(event.getClass().getSimpleName());
    }

    @Override
    public void beforeProcessCompleted(ProcessCompletedEvent event) {
        logger.info(event.getClass().getSimpleName());
    }

    @Override
    public void afterProcessCompleted(ProcessCompletedEvent event) {
        logger.info(event.getClass().getSimpleName());
    }

    @Override
    public void beforeNodeTriggered(ProcessNodeTriggeredEvent event) {
        logger.info(event.getClass().getSimpleName());
    }

    @Override
    public void afterNodeTriggered(ProcessNodeTriggeredEvent event) {
        logger.info(event.getClass().getSimpleName());
    }

    @Override
    public void beforeNodeLeft(ProcessNodeLeftEvent event) {
        logger.info(event.getClass().getSimpleName());
    }

    @Override
    public void afterNodeLeft(ProcessNodeLeftEvent event) {
        logger.info(event.getClass().getSimpleName());
    }

    @Override
    public void beforeVariableChanged(ProcessVariableChangedEvent event) {
        logger.info(event.getClass().getSimpleName());
    }

    @Override
    public void afterVariableChanged(ProcessVariableChangedEvent event) {
        logger.info(event.getClass().getSimpleName());
    }
}