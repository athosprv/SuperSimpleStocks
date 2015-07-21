/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package superSimpleStocks;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 *
 * @author geo53576
 */
public class FileInit {

    private File aFile;
    private Scanner sc;

    public FileInit(File aFile) throws FileNotFoundException {
        this.aFile = aFile;
        this.sc = new Scanner(aFile);
    }

    /**
     * @return the scanner
     */
    public Scanner getScanner() {
        return sc;
    }

}
