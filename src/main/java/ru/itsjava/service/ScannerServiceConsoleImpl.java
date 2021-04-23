package ru.itsjava.service;

import org.springframework.stereotype.Service;

import java.util.Scanner;

@Service
public class ScannerServiceConsoleImpl implements ScannerService{
    private Scanner console = new Scanner(System.in);

    @Override
    public String scannerStart() {
        System.out.println("Scanner is ready");
        String order = console.nextLine();
        return order;
    }
}
