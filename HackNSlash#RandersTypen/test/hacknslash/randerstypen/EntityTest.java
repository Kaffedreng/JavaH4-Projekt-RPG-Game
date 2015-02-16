/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hacknslash.randerstypen;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author jan
 */
public class EntityTest {
    
    public EntityTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of MaxHealth method, of class Entity.
     */
    @Test
    public void testMaxHealth() {
        System.out.println("MaxHealth");
        Entity instance = new Entity();
        instance.MaxHealth();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of Attack method, of class Entity.
     */
    @Test
    public void testAttack() {
        System.out.println("Attack");
        Entity instance = new Entity();
        int expResult = 1;
        int result = instance.Attack(1);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of Health method, of class Entity.
     */
    @Test
    public void testHealth() {
        System.out.println("Health");
        Entity instance = new Entity();
        int expResult = 0;
        int result = instance.Health();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of Level method, of class Entity.
     */
    @Test
    public void testLevel() {
        System.out.println("Level");
        Entity instance = new Entity();
        int expResult = 0;
        int result = instance.Level();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of DamageCalculator method, of class Entity.
     */
    @Test
    public void testDamageCalculator() {
        System.out.println("DamageCalculator");
        Entity instance = new Entity();
        int expResult = 1;
        int result = 1;
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of DamageTaken method, of class Entity.
     */
    @Test
    public void testDamageTaken() {
        System.out.println("DamageTaken");
        int Damage = 0;
        Entity instance = new Entity();
        instance.DamageTaken(Damage);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
