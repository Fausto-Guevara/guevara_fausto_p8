/*
 * @author Guevara Thomas Fausto Yahel
 * @version 1.0
 * @date 13-Junio-2024 
 */
import java.util.ArrayList;
import java.util.List;

public class JosephusPermutation {
    public static List<Integer> josephus(int n, int m) {
        List<Integer> result = new ArrayList<>();
        List<Integer> people = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            people.add(i);
        }
        josephusHelper(people, m - 1, 0, result);
        return result;
    }

    private static void josephusHelper(List<Integer> people, int m, int index, List<Integer> result) {
        if (people.size() == 0) {
            return;
        }
        index = (index + m) % people.size();
        result.add(people.remove(index));
        josephusHelper(people, m, index, result);
    }

    public static void main(String[] args) {
        int n = 7;
        int m = 3;
        List<Integer> permutation = josephus(n, m);
        System.out.println("La (7,3)-permutación de Josephus es: " + permutation);
    }
}
/*
 * 1.- Clasificaría el problema con una dificultad de 1. La razón es que, aunque el concepto detrás del problema es 
 * sencillo y se puede entender fácilmente, la implementación recursiva requiere un entendimiento sólido de 
 * las listas y cómo manejarlas.
 * 
 * 2.- lo más difícil del problema fue manejar el índice de manera circular en la lista y asegurar que el método 
 * recursivo elimina correctamente los elementos en el orden correcto.
 * 
 * 3.- Sí, el problema aporta conocimiento significativo sobre el uso de recursión y estructuras de datos dinámicas 
 * como las listas en Java
 * 
 * 4.- Son problemas no tan fáciles de solucionar debido a la atencion que requieren, pero con gusto haría alguno más
 * 
 * 5.-  La intención de este problema fue enseñar y evaluar la habilidad para implementar algoritmos recursivos y 
 * manejar estructuras de datos de manera eficiente
 * 
 */