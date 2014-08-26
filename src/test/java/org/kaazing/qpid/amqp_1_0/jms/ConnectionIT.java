/*
 * Copyright (c) 2007-2014, Kaazing Corporation. All rights reserved.
 */
package org.kaazing.qpid.amqp_1_0.jms;

import javax.jms.Connection;
import javax.jms.ConnectionFactory;

import org.apache.qpid.amqp_1_0.jms.impl.ConnectionFactoryImpl;
import org.junit.Ignore;
import org.junit.Rule;
import org.junit.Test;
import org.kaazing.robot.junit.annotation.Robotic;
import org.kaazing.robot.junit.rules.RobotRule;

public class ConnectionIT {

    @Rule
    public RobotRule robot = new RobotRule().setScriptRoot("org/kaazing/robot/scripts/amqp_1_0/jms/connection");

    @Robotic(script = "create.then.close")
    @Test(timeout = 1000)
    public void shouldCreateThenClose() throws Exception {
        ConnectionFactory factory = new ConnectionFactoryImpl("localhost", 5672, null, null, "clientID");
        Connection connection = factory.createConnection();
        connection.close();
        robot.join();
    }

    @Robotic(script = "start.then.close")
    @Test(timeout = 1000)
    public void shouldStartThenClose() throws Exception {
        ConnectionFactory factory = new ConnectionFactoryImpl("localhost", 5672, null, null, "clientID");
        Connection connection = factory.createConnection();
        connection.start();
        connection.close();
        robot.join();
    }

    @Ignore("check if QPID JMS supports this yet")
    @Robotic(script = "start.with.credentials.then.close")
    @Test(timeout = 1000)
    public void shouldStartWithCredentialsThenClose() throws Exception {
        ConnectionFactory factory = new ConnectionFactoryImpl("localhost", 5672, null, null, "clientID");
        Connection connection = factory.createConnection("username", "password");
        connection.start();
        robot.join();
    }

}
