package org.wildfly.swarm.it.jsf;

import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.arquillian.junit.Arquillian;
import org.jboss.shrinkwrap.api.Archive;
import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.importer.ZipImporter;
import org.jboss.shrinkwrap.api.spec.WebArchive;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.wildfly.swarm.arquillian.InVM;
import org.wildfly.swarm.examples.jsf.Message;

import javax.inject.Inject;
import java.io.File;

import static org.junit.Assert.assertNotNull;

/**
 * @author rmpestano
 */
@RunWith(Arquillian.class)
@InVM
public class JSFApplicationIt{

    @Inject
    Message message;

   /* @Deployment
    public static Archive createDeployment() {
        return ShrinkWrap.create(JARArchive.class)
                .addClass(Message.class);
    }*/

    @Deployment
    public static Archive createDeployment() {
        WebArchive war = ShrinkWrap.create(ZipImporter.class, "swarm-jsf.war").
                importFrom(new File("target/swarm-jsf.war")).as(WebArchive.class);
        return war;
    }

    @Test
    public void testIt() {
        assertNotNull(message.say());
    }
}
