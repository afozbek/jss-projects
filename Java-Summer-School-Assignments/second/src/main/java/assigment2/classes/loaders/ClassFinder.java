package assigment2.classes.loaders;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;

public class ClassFinder {
    /**
     * @param directory
     * @param packageName
     * @return classes
     * @throws ClassNotFoundException
     */
    private static List<Class> findClasses(File directory, String packageName) throws ClassNotFoundException {

        List<Class> classes = new ArrayList<Class>();

        if (!directory.exists()) {
            return classes;
        }
        File[] files = directory.listFiles();

        for (File file : files) {
            if (file.isDirectory()) {
                assert !file.getName().contains(".");
                classes.addAll(findClasses(file, packageName + "." + file.getName()));
            } else if (file.getName().endsWith(".class")) {
                classes.add(Class.forName(packageName + '.' + file.getName().substring(0, file.getName().length() - 6)));
            }
        }
        return classes;
    }

    /**
     * Scans all classes accessible from the context class loader which belong to the given package and subpackages.
     *
     * @param packageName The base package
     * @return The classes
     * @throws ClassNotFoundException
     * @throws IOException
     */
    public ArrayList<Class> getClasses(String packageName) throws ClassNotFoundException, IOException {
        ClassLoader classLoader = getClass().getClassLoader();

        assert classLoader != null;

        // Change package signature to package.anotherPackage to package/anotherPackage
        String path = packageName.replace('.', '/');

        // Getting the resources
        Enumeration<URL> resources = classLoader.getResources(path);

        // Initial directories
        List<File> dirs = new ArrayList<File>();

        while (resources.hasMoreElements()) {
            URL resource = resources.nextElement();
            dirs.add(new File(resource.getFile()));
        }

        // classes ArrayList which holds classes
        ArrayList<Class> classes = new ArrayList<Class>();

        for (File directory : dirs) {
            classes.addAll(findClasses(directory, packageName));
        }
        return classes;
    }

}
