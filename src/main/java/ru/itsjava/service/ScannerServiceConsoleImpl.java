package ru.itsjava.service;

import org.springframework.stereotype.Service;

import java.util.Scanner;

@Service
public class ScannerServiceConsoleImpl implements ScannerService{
    @Override
    public String scannerStart() {
        System.out.println("Scanner is ready");
        Scanner console = new Scanner(System.in);
        String order = console.nextLine();
        return order;
    }
}
