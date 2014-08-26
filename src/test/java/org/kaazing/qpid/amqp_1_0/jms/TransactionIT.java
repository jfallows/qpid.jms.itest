/*
 * Copyright (c) 2007-2014, Kaazing Corporation. All rights reserved.
 */
package org.kaazing.qpid.amqp_1_0.jms;

import static javax.jms.Session.CLIENT_ACKNOWLEDGE;
import static javax.jms.Session.DUPS_OK_ACKNOWLEDGE;
import static javax.jms.Session.SESSION_TRANSACTED;

import javax.jms.Connection;
import javax.jms.ConnectionFactory;

import org.apache.qpid.amqp_1_0.jms.impl.ConnectionFactoryImpl;
import org.junit.Rule;
import org.junit.Test;
import org.kaazing.robot.junit.annotation.Robotic;
import org.kaazing.robot.junit.rules.RobotRule;

public class TransactionIT {

    @Rule
    public RobotRule robot = new RobotRule().setScriptRoot("org/kaazing/robot/scripts/amqp_1_0/jms/transaction");

    @Robotic(script = "create")
    @Test(timeout = 1000)
    public void shouldCreateTransactedAutoAcknowledgeSession() throws Exception {
        ConnectionFactory factory = new ConnectionFactoryImpl("localhost", 5672, null, null, "clientID");
        Connection connection = factory.createConnection();
        connection.start();
        connection.createSession(true, SESSION_TRANSACTED);
        robot.join();
    }

    @Robotic(script = "create")
    @Test(timeout = 1000)
    public void shouldCreateTransactedClientAcknowledgeSession() throws Exception {
        ConnectionFactory factory = new ConnectionFactoryImpl("localhost", 5672, null, null, "clientID");
        Connection connection = factory.createConnection();
        connection.start();
        connection.createSession(true, CLIENT_ACKNOWLEDGE);
        robot.join();
    }

    @Robotic(script = "create")
    @Test(timeout = 1000)
    public void shouldCreateTransactedDupsOkayAcknowledgeSession() throws Exception {
        ConnectionFactory factory = new ConnectionFactoryImpl("localhost", 5672, null, null, "clientID");
        Connection connection = factory.createConnection();
        connection.start();
        connection.createSession(true, DUPS_OK_ACKNOWLEDGE);
        robot.join();
    }

}