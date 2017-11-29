
package business;


 // @author DUrban
 
public class Loan {
    public static final String AMTDESC = "Loan Amount";
    public static final String RESDESC = "Monthly Payment";
    
    private double amt, rate, mopmt;
    private int term;

    private String errmsg;
    private double[] bbal, intchg, ebal;

    private boolean built;
    
    public Loan (double a, double r, int t){
        this.amt =a;
        this.rate=r;
        this.term=t;
        this.built=false;
        this.mopmt=0;
        
        if (isValid()){
            buildLoan();
        }
    }
    private boolean isValid(){
        this.errmsg="";
        if (this.amt<=0){
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
    
    private void buildLoan(){
        double denom, morate;
       
        this.errmsg="";
        try{
            intchg = new double [this.term];
            bbal = new double [this.term];
            ebal = new double [this.term];
            
            bbal[0] = this.amt;
            for (int i=0; i < this.term; i++){
                if (i>0) {
                    this.bbal[i]=this.ebal[i-1];
                }
            
            morate = this.rate / 12.0;
            denom = Math.pow(1+morate,this.term)-1.0;
            this.mopmt=(morate+morate/denom)*this.amt;
            
            this.intchg[i] = (this.bbal[i]*
                                  morate);
             
            this.ebal[i]=
             this.bbal[i]+this.intchg[i]-this.mopmt;
            }
            this.built=true;
        }catch (Exception e){
            this.errmsg="Unable to build loan.";
            this.built=false;
        }
    }
        public String getErrorMsg(){
        return this.errmsg;
    }
        public double getFinalValue(){
        if (!this.built){
            buildLoan();
            if(!this.built){
                return -1;
            }
        }
        return ebal[this.term-1];
        }    
        public double getMoPmt(){
        return this.mopmt;
    }
        public double getBegbal(int mo){
        if (!this.built){
            buildLoan();
            if (!this.built){
                return -1;
            }
        }
        if (mo<1 || mo > this.term) {
            return -2;
        }
        return this.bbal[mo-1];
    }
        public int getTerm(){
        return this.term;
    }
        public double getIntChg (int mo){
        if (!this.built){
            buildLoan();
            if (!this.built){
                return -1;
            }
        }
        if (mo<1 || mo > this.term) {
            return -2;
        }
        return this.intchg[mo-1];
    }
        public double getEndBal(int mo){
        if (!this.built){
            buildLoan();
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