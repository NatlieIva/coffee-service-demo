package ru.itsjava.service;

import org.springframework.stereotype.Service;

import java.util.Scanner;

@Service
public class ScannerServiceConsoleImpl implements ScannerService{
    private final Scanner console = new Scanner(System.in);

    @Override
    public String readLine() {
        System.out.println("The scanner ready for your input");
        return console.nextLine();
    }
}
