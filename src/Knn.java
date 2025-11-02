import java.util.*;

import static java.lang.Math.pow;
import static java.lang.Math.sqrt;

public class Knn {
    public String clasificao(double[][]valoresConhecidos,String[]label,double[]aTestar,int kVisinhos){
        var distancias=distanciaEuclidiana(valoresConhecidos,aTestar);
        return clasificar(label,distancias,kVisinhos);
    }


    private double[] distanciaEuclidiana(double[][]testado,double[]testar){
        var distancias=new double[testado.length];
        for(int i=0;i<testado.length;i++){
            double soma=0;
            for(int i2=0;i2<testar.length;i2++){
               soma+= pow( testado[i][i2]-testar[i2],2);
            }
            distancias[i]=sqrt(soma);
        }

        return distancias;
    }

    private String clasificar(String[]label,double[]distancias,int kVisinhos){
        List<Par<Double,String>>mapaDasDistancias=new ArrayList<>();
        for(int i =0;i<label.length;i++){
            mapaDasDistancias.add(new Par<Double,String>(distancias[i],label[i]));
        }

          mapaDasDistancias.sort((a,b)->{
           return Double.compare(a.primeiro,b.primeiro);
          });
        ArrayList<Par<Double,String>> visinhos=new ArrayList();
        for(int i=0;i<kVisinhos;i++){
          visinhos.add(mapaDasDistancias.get(i));
        }



    return contagem(visinhos);
    }

    private String contagem(ArrayList<Par<Double,String>>visinhos){
        var listaDeContados=new LinkedList<String>();
        var listaContagenDosLAbels=new ArrayList<Par<Integer,String>>();
        int inicio=0;
        int fin=visinhos.size()-1;
        var contagen=0;
        var labbel=visinhos.get(inicio);
        while (inicio!=fin) {
            System.out.println("procurando os visinhos prosimos");
            if (!listaDeContados.contains(labbel.segundo)){
                for (int i = fin; i> inicio; i--) {
                    System.out.println("contando label");
                    if (visinhos.get(fin).segundo == labbel.segundo) contagen++;
                }
                listaContagenDosLAbels.add(new Par<>(contagen,labbel.segundo));
                listaDeContados.add(labbel.segundo);
        }
          inicio++;
          fin=visinhos.size()-1;
          contagen=0;
          labbel=visinhos.get(inicio);
        }
        listaContagenDosLAbels.sort((a,b)->{return Integer.compare(a.primeiro,b.primeiro);});
        return listaContagenDosLAbels.get(listaContagenDosLAbels.size()-1).segundo;
    }
}
