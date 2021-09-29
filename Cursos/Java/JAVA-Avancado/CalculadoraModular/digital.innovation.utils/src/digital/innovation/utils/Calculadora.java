package digital.innovation.utils;

import digital.innovation.utils.internal.MultHelper;
import digital.innovation.utils.internal.SubHelper;
import digital.innovation.utils.internal.SumHelper;
import digital.innovation.utils.internal.DivHelper;

public class Calculadora {

    private DivHelper divHelper;
    private MultHelper multHelper;
    private SubHelper subHelper;
    private SumHelper sumHelper;

    public Calculadora(){
        divHelper = new DivHelper();
        multHelper = new MultHelper();
        sumHelper = new SumHelper();
        subHelper = new SubHelper();

    }

    public int sum(int a, int b){
        return sumHelper.execute(a, b);
    }

    public int sub(int a, int b){
        return subHelper.execute(a, b);
    }

    public int div(int a, int b){
        return divHelper.execute(a, b);
    }

    public int mult(int a, int b){
        return multHelper.execute(a, b);
    }
}
