package br.com.drools.corrida.listener;

import org.drools.core.event.*;
import org.drools.core.event.AgendaGroupPoppedEvent;
import org.drools.core.event.AgendaGroupPushedEvent;
import org.kie.api.event.rule.*;
import org.kie.api.event.rule.RuleFlowGroupActivatedEvent;
import org.kie.api.event.rule.RuleFlowGroupDeactivatedEvent;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class CorridaAgendaEventListener
    implements AgendaEventListener {

    private static final Logger logger =
LoggerFactory.getLogger(CorridaAgendaEventListener.class);

    public void activationCancelled(ActivationCancelledEvent
                                    event) {
        logger.info(event.getClass().getSimpleName() + " REGRA: " +
                         event.getActivation());
    }

    public void activationCreated(ActivationCreatedEvent
                                  event) {
        logger.info(event.getClass().getSimpleName() + " REGRA: " +
                event.getActivation());
    }

    public void beforeActivationFired(
        BeforeActivationFiredEvent event) {
        logger.info(event.getClass().getSimpleName() + " REGRA: " +
                event.getActivation());
    }

    public void afterActivationFired(AfterActivationFiredEvent
        event) {
        logger.info(event.getClass().getSimpleName() + " REGRA: " +
                event.getActivation() + " - " + event.getActivation().getRule());
    }

    public void agendaGroupPopped(AgendaGroupPoppedEvent            
                                  event) {
        logger.info(event.getClass().getSimpleName() + " REGRA: " +
                    event.getAgendaGroup());
    }

    public void agendaGroupPushed(AgendaGroupPushedEvent
                                  event) {
        logger.info(event.getClass().getSimpleName() + " REGRA: " +
                     event.getAgendaGroup());
    }

    @Override
    public void matchCreated(MatchCreatedEvent event) {
        logger.info(event.getClass().getSimpleName() +" REGRA: " +
                event.getMatch().getRule().getName());
    }

    @Override
    public void matchCancelled(MatchCancelledEvent event) {
        logger.info(event.getClass().getSimpleName() +" REGRA: " +
                event.getMatch().getRule().getName());
    }

    @Override
    public void beforeMatchFired(BeforeMatchFiredEvent event) {
        logger.info(event.getClass().getSimpleName() +" REGRA: " +
                event.getMatch().getRule().getName());
    }

    @Override
    public void afterMatchFired(AfterMatchFiredEvent event) {
        logger.info(event.getClass().getSimpleName() +" REGRA: " +
                event.getMatch().getRule().getName());
    }

    @Override
    public void agendaGroupPopped(org.kie.api.event.rule.AgendaGroupPoppedEvent event) {
        logger.info(event.getClass().getSimpleName() +" REGRA: " +
                event.getAgendaGroup().getName());
    }

    @Override
    public void agendaGroupPushed(org.kie.api.event.rule.AgendaGroupPushedEvent event) {
        logger.info(event.getClass().getSimpleName() +" REGRA: " +
                event.getAgendaGroup().getName());
    }

    @Override
    public void beforeRuleFlowGroupActivated(RuleFlowGroupActivatedEvent event) {
        logger.info(event.getClass().getSimpleName() +" REGRA: " +
                event.getRuleFlowGroup().getName());
    }

    @Override
    public void afterRuleFlowGroupActivated(RuleFlowGroupActivatedEvent event) {
        logger.info(event.getClass().getSimpleName() +" REGRA: " +
                event.getRuleFlowGroup().getName());
    }

    @Override
    public void beforeRuleFlowGroupDeactivated(RuleFlowGroupDeactivatedEvent event) {
        logger.info(event.getClass().getSimpleName() +" REGRA: " +
                event.getRuleFlowGroup().getName());
    }

    @Override
    public void afterRuleFlowGroupDeactivated(RuleFlowGroupDeactivatedEvent event) {
        logger.info(event.getClass().getSimpleName() + " REGRA: " +
                event.getRuleFlowGroup().getName());
    }
}