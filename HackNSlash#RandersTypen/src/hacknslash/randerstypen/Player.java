/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hacknslash.randerstypen;

/**
 *
 * @author jan
 */
public class Player extends Entity {
    int Regen;
    int Exp;
    boolean Combat;
    String CurrPos;
    String LastPos;
    int MapLevel;
    
    /**
     *
     * @param Name
     * @param Level
     * @param Experience
     * @param MapLevel
     * @param CurrPosition
     * @param Health
     */
    public Player(String Name, int Level, int Experience, int MapLevel, String CurrPosition, int Health) {
        this.EntityName = Name;
        this.Level = Level;
        this.Exp = Experience;
        this.MapLevel = MapLevel;
        this.CurrPos = CurrPosition;
        this.Health = Health;
    }
    public int MapLevel() {
        return MapLevel;
    }

    public String GetLastPos() {
        return LastPos;
    }
    
    public String LastPos() {
        return LastPos;
    }
    
    public String CurrPos() {
        return CurrPos;
    }

    void RegenHealth() {
        
    }

    public void SetPos(String NewPos) {
        LastPos = CurrPos;
        CurrPos = NewPos;
    }

    void GiveExp(int MapLevel) {
        this.Exp = MapLevel * 25;
        if(this.Level * 100 < this.Exp) {
            this.Level = this.Level + 1;
            this.Exp = 0;
        }
    }
}
