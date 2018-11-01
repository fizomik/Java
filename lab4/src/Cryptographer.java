import java.io.*;

public class Cryptographer {
    public static String line= null;
    public static void cryptfile(File toRead, File toWrite, Algorithm o1 ) throws IOException {

        BufferedReader bf=null;

        try{
            bf = new BufferedReader(new FileReader(toRead));
            do{
                line=bf.readLine();
                if (line!=null){
                    line=o1.crypt(line);
                    FileWriter fileWriter=null;

                    try{
                        fileWriter =new FileWriter(toWrite, true);
                        fileWriter.write(line);
                        fileWriter.write("\n");



                    }catch (IOException ex){
                        System.out.print("Problem z dostepem przy zapisie");
                    }

                    finally {
                        if (fileWriter==null)
                            System.out.print("Problem z dostepem przy zapisie (null)");
                        else
                            fileWriter.close();
                    }
                }

            }while(line!=null);

        }catch (IOException ex){
            System.out.print("Problem z dostepem przy wczytywaniu");
        }



    }




    public static void decryptfile(File toRead, File toWrite, Algorithm o1 )
    {


        BufferedReader bf=null;

        try{
            bf = new BufferedReader(new FileReader(toRead));
            do{
                line=bf.readLine();
                if (line!=null){
                    line=o1.decrypt(line);
                    FileWriter fileWriter=null;

                    try{
                        fileWriter =new FileWriter(toWrite, true);
                        fileWriter.write(line);
                        fileWriter.write("\n");


                    }catch (IOException ex){
                        System.out.print("Problem z dostepem przy zapisie");
                    }

                    finally {
                        if (fileWriter==null)
                            System.out.print("Problem z dostepem przy zapisie (null)");
                        else
                            fileWriter.close();
                    }
                }

            }while(line!=null);

        }catch (IOException ex){
            System.out.print("Problem z dostepem przy wczytywaniu");
        }





    }
}