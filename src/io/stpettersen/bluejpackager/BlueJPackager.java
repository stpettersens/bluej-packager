/*
BlueJ Packager.
Utility to morph a BlueJ project into a structured Java package.

Copyright (c) 2016 Sam Saint-Pettersen.
Released under the MIT License.
*/
package io.stpettersen.bluejpackager;
import org.apache.commons.cli.*;

public class BlueJPackager {

    private static void packageApp(String pkg, String mainClass, String root, boolean verbose) {
        // TODO
    }

    private static void displayUsage(Options options, int exitCode) {
        System.out.println("\nBlueJ Packager.");
        System.out.println("Utility to morph a BlueJ project into a structured Java package.");
        System.out.println("\nCopyright (c) 2016 Sam Saint-Pettersen.");
        System.out.println("Released under the MIT License.\n");
        for(Option opt: options.getOptions()) {
            String[] fopt = opt.toString().split("::", 3);
            System.out.println(fopt[0].replace("[ option: ", "-") + ":" + fopt[1]);
        }
        System.out.println("");
        System.exit(exitCode);
    }

    public static void main(String[] args) {
        // Create the command line parser.
        CommandLineParser parser = new DefaultParser();

        // Create the command line options.
        Options options = new Options();
        options.addOption("h", "help", false, "Display this help information and exit.");
        options.addOption("v", "version", false, "Display version information and exit.");
        options.addOption("p", "package", true, "Package string to use.");
        options.addOption("m", "mainClass", true, "Main class to use.");
        options.addOption("cp", "classPath", true, "Class path directory.");
        options.addOption("r", "root", true, "Root directory.");
        options.addOption("l", "verbose", false, "Be verbose.");

        try {
            // Parse the command line arguments.
            CommandLine cli = parser.parse(options, args);
            if(cli.hasOption("h")) displayUsage(options, 0);
        }
        catch(Exception e) {
            // Bad command line option occurred.
            System.err.println("\nError: " + e.getMessage());
            displayUsage(options, 1);
        }
    }
}
