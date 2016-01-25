package org.wildfly.swarm.it.jsf;

import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.arquillian.drone.api.annotation.Drone;
import org.jboss.arquillian.junit.Arquillian;
import org.jboss.shrinkwrap.api.Archive;
import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;
import org.wildfly.swarm.arquillian.InVM;
import org.wildfly.swarm.container.JARArchive;
import org.wildfly.swarm.examples.jsf.Message;

import javax.inject.Inject;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

/**
 * @author Bob McWhirter
 */
@RunWith(Arquillian.class)
public class JSFApplicationTest{

    @Inject
    Message message;

    @Deployment
    public static Archive createDeployment() {
        return ShrinkWrap.create(JARArchive.class)
                .addClass(Message.class);
    }

    @Test
    public void testIt() {
        assertNotNull(message.say());
    }
}
