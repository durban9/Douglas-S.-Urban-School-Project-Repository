
package business;


 // @author DUrban
 
public class Annuity {
    
    public static final String AMTDESC = "Monthly Deposit";
    public static final String RESDESC = "End Value of Annuity";
    
    private double deposit, rate;
    private int term;

    private String errmsg;
    private double[] bbal, intearn, ebal;

    private boolean built;
    
    public Annuity(double d, double r, int t){
        // constructor
        this.deposit=d;
        this.rate=r;
        this.term=t;
        this.built = false;
        this.errmsg="";
        
        if (isValid()){
            buildAnnuity();
        }
    }
    private boolean isValid(){
        this.errmsg="";
        if (this.deposit<=0){
            this.errmsg+="Amount is illegal. ";
        }
        if (this.rate<=0 || this.rate>=1.0) {
            this.errmsg+="Rate out of bounds. ";
        }
        if (this.term<=0){
            this.errmsg+="Term is illegal";
        }
        return (this.errmsg.isEmpty());
    }
    private void buildAnnuity(){
        this.errmsg="";
        try {
            bbal = new double [this.term];
            intearn = new double [this.term];
            ebal = new double [this.term];
            
            bbal[0] = 0;
            for (int i=0; i < this.term; i++){
                if (i>0) {
                    this.bbal[i]=this.ebal[i-1];
                }
                this.intearn[i] = (this.bbal[i]+this.deposit)*
                                  (this.rate/12.0);
                this.ebal[i]=
                        this.bbal[i]+this.intearn[i]+this.deposit;
            }
            this.built=true;
        }catch (Exception e){
            this.errmsg="Unable to build annuity:" + e.getMessage();     
            this.built=false;
        }
    }
    public String getErrorMsg(){
        return this.errmsg;
    }
    public double getFinalValue(){
        if (!this.built){
            buildAnnuity();
            if(!this.built){
                return -1;
            }
        }
        return ebal[this.term-1];
    }
    public double getDeposit(){
        return this.deposit;
    }
    public double getRate(){
        return this.rate;
    }
    public int getTerm(){
        return this.term;
    }
    public double getBegbal(int mo){
        if (!this.built){
            buildAnnuity();
            if (!this.built){
                return -1;
            }
        }
        if (mo<1 || mo > this.term) {
            return -2;
        }
        return this.bbal[mo-1];
    }
    public double getIntEarn (int mo){
        if (!this.built){
            buildAnnuity();
            if (!this.built){
                return -1;
            }
        }
        if (mo<1 || mo > this.term) {
            return -2;
        }
        return this.intearn[mo-1];
    }
    public double getEndBal(int mo){
        if (!this.built){
            buildAnnuity();
            if (!this.built){
                return -1;
            }
        }
        if (mo<1 || mo > this.term) {
            return -2;
        }
        return this.ebal[mo-1];
    }
}
