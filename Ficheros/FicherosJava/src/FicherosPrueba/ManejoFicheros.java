package FicherosPrueba;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;

public class ManejoFicheros {
    private ManejoFicheros() {
    }
    public static void crearFichero(String path) throws IOException {
        try {
            String[] pathVector = path.split("\\\\");
            StringBuilder newPath = new StringBuilder();
            for (int i = 0; i < pathVector.length-1 ; i++) {
                newPath.append(pathVector[i]);
                if(i!=pathVector.length-2){
                    newPath.append("\\");
                }
            }
            File newDirectory = new File(String.valueOf(newPath));
            if (newDirectory.mkdirs()){
                System.out.println("Se ha creado el directorio "+ newDirectory.getPath());
            }
            File f = new File(path);
            if((!f.exists())&&(f.createNewFile())){
                System.out.println("Fichero creado con exito");
            }else{
                System.out.println("No ha podido crearse el fichero");
            }
        } catch (IOException e) {
            System.out.println("Ha ocurrido un error. "+ e.getMessage());
        }
    }

    public static void borrarFichero(String path){
        try {
            File f = new File(path);
            if((f.exists())&&(f.delete())){
                System.out.println("Fichero borrado con exito");
            }
        } catch (Exception e) {
            System.out.println("Ha ocurrido un error del tipo "+ e.getMessage());
        }
    }

    public static void crearDirectorio(String path){
        try {
            File newDirectory = new File(path);
            if((!newDirectory.exists())&&(newDirectory.mkdirs())){
                System.out.println("Direcotorio creado con exito");
            }
        } catch (Exception e) {
            System.out.println("Ha ocurrido un error del tipo "+ e.getMessage());
        }
    }

    public static void borrarDirectorio(String path){
        try {
            File f = new File(path);
            if((f.exists())&&(f.isDirectory())&&(f.delete())){
                System.out.println("Direcotorio borrado con exito");
            }
        } catch (Exception e) {
            System.out.println("Ha ocurrido un error del tipo "+ e.getMessage());
        }
    }

    public static void listarDirectorio(String path){
        try {
            File f = new File(path);
            File[] contenidoDirectorio = f.listFiles();
            if ((contenidoDirectorio!=null)&&(contenidoDirectorio.length>0)){
                for (int i = 0; i <contenidoDirectorio.length ; i++) {
                    System.out.println(f.getName());
                    if (contenidoDirectorio[i].isDirectory()){
                        listarDirectorio(contenidoDirectorio[i].getPath(),i);
                    }
                }
            }
        } catch (Exception e) {
            System.out.println("Ha ocurrido un error del tipo "+ e.getMessage());
        }
    }
    public static void listarDirectorio(String path, int indexacion){
        try {
            StringBuilder tabulacion = new StringBuilder("-*");
            for (int i = 0; i < indexacion; i++) {
                tabulacion.append("-*");
            }
            File f = new File(path);
            File[] contenidoDirectorio = f.listFiles();
            if ((contenidoDirectorio!=null)&&(contenidoDirectorio.length>0)){
                for (int i = 0; i <contenidoDirectorio.length ; i++) {
                    System.out.println(tabulacion + f.getName());
                    if (contenidoDirectorio[i].isDirectory()){
                        listarDirectorio(contenidoDirectorio[i].getPath(),i);
                    }
                }
            }
        } catch (Exception e) {
            System.out.println("Ha ocurrido un error del tipo "+ e.getMessage());
        }
    }

}
