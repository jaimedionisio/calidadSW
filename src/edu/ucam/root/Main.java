package edu.ucam.root;
import java.util.*;

import edu.ucam.aplicacion.CargaDeDatos;
import edu.ucam.aplicacion.Menu;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;




public class Main {
	
		public static void main(String[] args) {
	
		CargaDeDatos.CargarDatos();
		Menu.Menu();
	}
}
