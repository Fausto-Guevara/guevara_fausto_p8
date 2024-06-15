/*
 * @author Guevara Thomas Fausto Yahel
 * @version 1.0
 * @date 13-Junio-2024 
 */
public class MyString {
    private char[] caracteres;

    // Constructor que acepta un arreglo de caracteres
    public MyString(char[] arregloCaracteres) {
        this.caracteres = new char[arregloCaracteres.length];
        System.arraycopy(arregloCaracteres, 0, this.caracteres, 0, arregloCaracteres.length);
    }

    // Constructor que acepta una longitud
    public MyString(int longitud) {
        this.caracteres = new char[longitud];
    }

    // Método para sustituir un carácter en una posición específica
    public void ingresarEn(int posicion, char caracter) {
        if (posicion < 0 || posicion >= this.caracteres.length) {
            throw new IndexOutOfBoundsException("Posición fuera de los límites del arreglo.");
        }
        this.caracteres[posicion] = caracter;
    }

    // Método para obtener una subcadena desde la posición inicial
    public MyString substring(int inicio) {
        if (inicio < 0 || inicio >= this.caracteres.length) {
            throw new IndexOutOfBoundsException("Posición de inicio fuera de los límites del arreglo.");
        }
        int nuevaLongitud = this.caracteres.length - inicio;
        char[] subcaracteres = new char[nuevaLongitud];
        System.arraycopy(this.caracteres, inicio, subcaracteres, 0, nuevaLongitud);
        return new MyString(subcaracteres);
    }

    // Método para obtener una subcadena desde la posición inicial hasta la posición final
    public MyString substring(int inicio, int fin) {
        if (inicio < 0 || fin > this.caracteres.length || inicio > fin) {
            throw new IndexOutOfBoundsException("Posiciones fuera de los límites del arreglo.");
        }
        int nuevaLongitud = fin - inicio;
        char[] subcaracteres = new char[nuevaLongitud];
        System.arraycopy(this.caracteres, inicio, subcaracteres, 0, nuevaLongitud);
        return new MyString(subcaracteres);
    }

    // Convertir a cadena de texto
    public String toString() {
        return new String(this.caracteres);
    }

    // Longitud de la cadena
    public int length() {
        return this.caracteres.length;
    }

    // Verificar si está vacío
    public boolean isEmpty() {
        return this.caracteres.length == 0;
    }

    // Concatenar otro MyString
    public MyString concat(MyString otraCadena) {
        int nuevaLongitud = this.caracteres.length + otraCadena.length();
        char[] nuevosCaracteres = new char[nuevaLongitud];
        System.arraycopy(this.caracteres, 0, nuevosCaracteres, 0, this.caracteres.length);
        System.arraycopy(otraCadena.caracteres, 0, nuevosCaracteres, this.caracteres.length, otraCadena.length());
        return new MyString(nuevosCaracteres);
    }

    // Encontrar el índice de un carácter
    public int indexOf(char caracter) {
        for (int i = 0; i < this.caracteres.length; i++) {
            if (this.caracteres[i] == caracter) {
                return i;
            }
        }
        return -1; // Retorna -1 si el carácter no se encuentra
    }

    public static void main(String[] args) {
        // Prueba de los constructores
        MyString cadena1 = new MyString(new char[]{'H', 'o', 'l', 'a'});
        MyString cadena2 = new MyString(5);

        // Utilización de cadena2 para evitar advertencia
        for (int i = 0; i < cadena2.length(); i++) {
            cadena2.ingresarEn(i, 'x');
        }
        System.out.println("Cadena2 después de inicializar: " + cadena2.toString()); 

        // Prueba del método ingresarEn
        cadena1.ingresarEn(1, 'a');
        System.out.println("Después de ingresarEn: " + cadena1.toString()); 

        // Prueba del método substring (una versión)
        MyString subcadena1 = cadena1.substring(1);
        System.out.println("Subcadena desde 1: " + subcadena1.toString()); 

        // Prueba del método substring (otra versión)
        MyString subcadena2 = cadena1.substring(1, 3);
        System.out.println("Subcadena desde 1 hasta 3: " + subcadena2.toString()); 

        // Prueba del método length
        System.out.println("Longitud: " + cadena1.length()); 

        // Prueba del método isEmpty
        System.out.println("Está vacío: " + cadena1.isEmpty()); 

        // Prueba del método concat
        MyString cadena3 = new MyString(new char[]{' ', 'M', 'u', 'n', 'd', 'o'});
        MyString concatenada = cadena1.concat(cadena3);
        System.out.println("Concatenada: " + concatenada.toString());

        // Prueba del método indexOf
        System.out.println("Índice de 'a': " + cadena1.indexOf('a')); 
        System.out.println("Índice de 'z': " + cadena1.indexOf('z')); 
    }
}

/*
 * 1.- Lo más difícil de este problema fue asegurarme de que todos los métodos implementados 
 * fueran consistentes con los de la clase String
 * 
 * 2.- Hubiera reducido la cantidad metodos adicionales requeridos
 * 
 * 3.- Hubiera anexado la implementación de más métodos de la clase String para mayor funcionalidad
 * 
 * 4.- Contar con ejemplos detallados y pruebas habría facilitado la implementación de las 
 * funcionalidades solicitadas.
 */