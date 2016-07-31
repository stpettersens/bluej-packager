/*
BlueJ Packager.
Utility to morph a BlueJ project into a structured Java package.

Copyright (c) 2016 Sam Saint-Pettersen.
Released under the MIT License.
*/
package io.stpettersen.bluejpackager;
import org.apache.commons.cli.*;

public class BlueJPackager {

    private static void displayUsage() {
        System.out.println("\nBlueJ Packager.");
        System.out.println("Utility to morph a BlueJ project into a structured Java package.");
        System.out.println("\nUsage: blpackager");
    }

    public static void main(String[] args) {
        // Create the command line parser.
        CommandLineParser parser = new DefaultParser();

        // Create the command line options.
        Options options = new Options();
        options.addOption("h", "help", false, "Display this help information and exit.");

        try {
            // Parse the command line arguments.
            CommandLine cli = parser.parse(options, args);
            if(cli.hasOption("h")) displayUsage();
        }
        catch(Exception e) {
            // Bad command line option occurred.
            System.err.println(e.getMessage());
        }
    }
}
