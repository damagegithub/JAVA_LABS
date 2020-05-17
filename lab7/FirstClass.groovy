class FirstClass {
    Integer x ;
    float f;
    BigInteger bi ;
    def binding;

    FirstClass(int x,float f, BigInteger bi){
        this.x = x;
        this.f= f;
        this.bi=bi;
    }

    FirstClass(){
        this.binding = new Binding(x:100,f:1.5,bi:2g);
    }

    Integer getInt()
    {
       x;
    }
}