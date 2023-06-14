public class Boy implements Injector{

    StringBuilder sb = new StringBuilder();
    Sewwandi abc = new Sewwandi();      // Property Injection / Field Injection
    GoodGirl gf;

    public Boy() {
        this.gf = new Nayani();  // Constructor Injection
    }

    public void setGf(GoodGirl gf) {
        this.gf = gf;           // Setter Method Injection
    }

    @Override
    public void inject() {
        sb = new StringBuilder();   // Interface through injection
    }

    public void kissMyGf(){
        while (true){
            gf.kiss();
        }
    }


}
