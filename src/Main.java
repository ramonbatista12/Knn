//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
       String[] label = {
                "Maçã",
                "Maçã",
                "Maçã",
                "Laranja",
                "Laranja",
                "Laranja"
        };
        double[][] valoresConhecidos = {
                {150, 8},
                {130, 7},
                {180, 9},
                {300, 4},
                {320, 5},
                {280, 3}
        };
        double[][] testes = {
                {160, 8},  // deve ser Maçã
                {290, 4},  // deve ser Laranja
                {200, 6},  // deve ser Laranja
                {140, 7}   // deve ser Maçã
        };
        var knn = new Knn();
        for(int i=0;i<testes.length;i++){
            System.out.println("Ola vou clasificar uma nova fruta com os sequintes valores peso "+testes[i][0]+" docura "+testes[i][1]);

            var clasificacao =knn.clasificao(valoresConhecidos,label,testes[i],3);
            System.out.println("A fruta foi clasificada como "+clasificacao);
        }

    }
}