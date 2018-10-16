/**
 * @author Damian
 */
public class Matrix {


    int dimension;
    int[] tab;

    public Matrix(){

        dimension=0;
    }

    public Matrix(int[] _tab, int _dimension) {
        dimension = _dimension;
        tab = _tab.clone();
    }

    public void show() {
        
        for (int i = 0; i < (dimension * dimension); i++) {
            if ((i % dimension) == 0)
                System.out.println();
           
            System.out.print(tab[i] + " ");
        }   
        System.out.println();
    }

    public Matrix add(Matrix o1) {

        int[] result = new int[dimension * dimension];
        for (int i = 0; i < dimension * dimension; i++) {
            result[i] = tab[i] + o1.tab[i];
        }
        Matrix suma = new Matrix(result, dimension);
        return suma;

        
    }

    public Matrix sub(Matrix o1) {

        int[] result = new int[dimension * dimension];
        for (int i = 0; i < dimension * dimension; i++) {
            result[i] = tab[i] - o1.tab[i];
        }
        Matrix minus = new Matrix(result, dimension);
        return minus;

    }

    public Matrix mul(Matrix o1) {

        int[] result = new int[dimension * dimension];
        int column;
        int line;
        for (int i = 0; i < dimension * dimension; i++)
        {
            column = i % dimension;
            line = i / dimension;

            for (int j = line * dimension; j < (dimension * line + dimension); j++)
            {
                result[i] += (tab[j] * o1.tab[column]);
                column += dimension;
            }
        }

        Matrix product = new Matrix(result, dimension);
        return product;

    }


}