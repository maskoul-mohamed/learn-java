/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */

package com.mycompany.countries;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Frame;
import java.awt.GridLayout;
import java.awt.Label;
import java.awt.Panel;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.StringTokenizer;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author mmaskoul
 */
public class Countries extends Frame implements ActionListener  {
    private Label lblName, lblCapital, lblPopulation, lblContinent;
    private TextField txtName, txtCapital, txtPopulation, txtContinent;
    private Button btnAdd, btnDelete, btnEdit, btnValidate;
    private Button btnFirst, btnLast, btnNext, btnPrevious;
    private Panel pAction, pLabel, pText, pNav;
    private ArrayList<Country> listCountries = new ArrayList<Country>();
    private int index = 0;
    private String mode = "add";

    public Countries(){
        this.setTitle("Countries");
        this.setSize(400, 500);
        
        lblName = new Label("Name");
        lblCapital = new Label("Capital");
        lblPopulation = new Label("Population");
        lblContinent = new Label("Continent");
        
        txtName = new TextField();
        txtCapital = new TextField();
        txtPopulation = new TextField();
        txtContinent = new TextField();
        
        
        btnAdd = new Button("Add");
        btnDelete = new Button("Delete");
        btnEdit = new Button("Edit");
        btnValidate = new Button("Validate");
        
        btnFirst = new Button("First");
        btnLast = new Button("Last");
        btnNext = new Button("Next");
        btnPrevious = new Button("Previous");
        
        btnAdd.addActionListener(this);
        btnDelete.addActionListener(this);
        btnEdit.addActionListener(this);
        btnValidate.addActionListener(this);
        
        btnFirst.addActionListener(this);
        btnLast.addActionListener(this);
        btnNext.addActionListener(this);
        btnPrevious.addActionListener(this);
        
        
        pAction = new Panel();
        pLabel = new Panel();
        pText = new Panel();
        pNav = new Panel();
        
        this.add(pAction, BorderLayout.NORTH);
        this.add(pLabel, BorderLayout.WEST);
        this.add(pText, BorderLayout.CENTER);
        this.add(pNav, BorderLayout.SOUTH);
        
        pAction.add(btnAdd);
        pAction.add(btnEdit);
        pAction.add(btnValidate); 
        pAction.add(btnDelete); 
        pAction.setLayout(new GridLayout(1,4));
        
        pLabel.add(lblName);
        pLabel.add(lblCapital);
        pLabel.add(lblPopulation);
        pLabel.add(lblContinent);        
        pLabel.setLayout(new GridLayout(4,1));
        
        pText.add(txtName);
        pText.add(txtCapital);
        pText.add(txtPopulation);
        pText.add(txtContinent);
        pText.setLayout(new GridLayout(4,1));
        
        pNav.add(btnFirst);
        pNav.add(btnPrevious);
        pNav.add(btnNext);
        pNav.add(btnLast);
        pNav.setLayout(new GridLayout(1,4));

        this.setVisible(true);
        activeEdit(true);
        readData();
        display();
    }
    
    public void activeEdit(Boolean state){
        btnAdd.setEnabled(state);
        btnEdit.setEnabled(state);
        btnDelete.setEnabled(state);
        btnValidate.setEnabled(!state);
        
        txtName.setEditable(!state);
        txtCapital.setEditable(!state);
        txtPopulation.setEditable(!state);
        txtContinent.setEditable(!state);
        
        btnNext.setEnabled(state);
        btnFirst.setEnabled(state);
        btnLast.setEnabled(state);
        btnPrevious.setEnabled(state);
    }
    
    public void readData(){
        BufferedReader  br;
        try {
              br = new BufferedReader(new FileReader("countries.txt"));
            String line = br.readLine();
			while (line != null) {
				StringTokenizer tmpSplit = new StringTokenizer(line,";");
                                Country country = new Country();
                                country.setName(tmpSplit.nextToken());
                                country.setCapital(tmpSplit.nextToken());
                                country.setPopulation(Long.parseLong(tmpSplit.nextToken()));
                                country.setContinent(tmpSplit.nextToken());
                                listCountries.add(country);
				line = br.readLine();
			}
			br.close();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Countries.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Countries.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    
    public void display() {
        txtName.setText(listCountries.get(index).getName());
        txtCapital.setText(listCountries.get(index).getCapital());
        txtPopulation.setText(Long.toString(listCountries.get(index).getPopulation()));
        txtContinent.setText(listCountries.get(index).getContinent());
    }
    @Override
    public void actionPerformed(ActionEvent e) {

        if(e.getSource() == btnAdd){
            activeEdit(false);
            txtName.setText("");
            txtCapital.setText("");
            txtPopulation.setText("");
            txtContinent.setText("");
        } else if(e.getSource() == btnDelete){
            if(listCountries.size() > 0){
                listCountries.remove(index);
                display();
            }
        }
    }
    
    public static void main(String[] args) {
        new Countries();
    }

  
}
