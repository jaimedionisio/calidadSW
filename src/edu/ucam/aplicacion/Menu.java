package edu.ucam.aplicacion;

import java.util.Scanner;

/** Clase menu*/


public class Menu {
	public static void Menu() {
		@SuppressWarnings("resource")
		Scanner read = new Scanner(System.in);

		read = new Scanner(System.in);
		int Seleccion = 0; // Primer Menu

    do {
      System.out.println("\n 1.Menu Armas");
			System.out.println("\n 2.Menu Personajes");
			System.out.println("\n 3.Menu Reinos");
			System.out.println("\n 4.Menu Ejercitos");
			System.out.println("\n 5.Menu Batallas");
			System.out.println("\n 6.Menu Guardar o Importar Datos");
			System.out.println("\n 7.Salir");
			System.out.println("");
			System.out.print("Ingrese Opci�n: ");
			Seleccion = read.nextInt();
			switch (Seleccion) {
			case 1:
				int menuArmas = 0;
				do {
					System.out.println("\n\n***************************\n\n");
					System.out.println(" Menu Armas");
					System.out.println(" Que va a Realizar...");
					System.out.println("\n 1.Listar Armas.");
					System.out.println("\n 2.Crear Arma Nueva");
					System.out.println("\n 3.Borrar Arma.");
					System.out.println("\n 4.Editar Arma.");
					System.out.println("\n 5.Buscar Arma.");
					System.out.println("\n 6.Volver Atras.");
					menuArmas = read.nextInt();
					switch (menuArmas) {
					case 1:
						Arma.listarArmas();
						System.out.println("Presione cualquier tecla para continuar.");
						Scanner c1 = new Scanner(System.in);
						c1.nextLine();
						break;
					case 2:
						Arma.ColeccionArmas.add(Arma.crearArma());
						System.out.println("Presione cualquier tecla para continuar.");
						Scanner c2 = new Scanner(System.in);
						c2.nextLine();
						break;
					case 3:
						System.out.println("Introduce el Id del arma a Borrar.");
						Scanner c3 = new Scanner(System.in);
						String armaABorrar = c3.nextLine();
						Arma.borrarArma(Arma.BuscarArma(Integer.parseInt(armaABorrar)));
						System.out.println("Presione cualquier tecla para continuar.");
						Scanner c4 = new Scanner(System.in);
						c4.nextLine();
						break;
					case 4:
						System.out.println("Introduce el Id del arma a Editar.");
						Scanner c5 = new Scanner(System.in);
						String armaAEditar = c5.nextLine();
						Arma.EditarArma(Arma.BuscarArma(Integer.parseInt(armaAEditar)));
						System.out.println("Presione cualquier tecla para continuar.");
						Scanner c6 = new Scanner(System.in);
						c6.nextLine();
						break;
					case 5:
						System.out.println("Introduce el ID del arma a Buscar.");
						Scanner c7 = new Scanner(System.in);
						String armaABuscar = c7.nextLine();
						Arma Armaencontrada = Arma.BuscarArma(Integer.parseInt(armaABuscar));
						if (Armaencontrada != null) {
							Armaencontrada.MostrarInfo();
						} else {
							System.out.println("No s eha encontrado el arma");
						}
						System.out.println("Presione cualquier tecla para continuar.");
						Scanner c8 = new Scanner(System.in);
						c8.nextLine();
						break;
					default:
						System.out.println("Selecciono Volver Atras.");
					}

				} while (menuArmas < 6);
				break;

			case 2:
				int menuPersonajes = 0;
				do {
					System.out.println("\n\n***************************\n\n");
					System.out.println(" Menu Personajes");
					System.out.println(" Que va a Realizar...");
					System.out.println("\n 1.Listar personajes.");
					System.out.println("\n 2.Crear personaje nuevo");
					System.out.println("\n 3.Borrar personaje.");
					System.out.println("\n 4.Editar personaje.");
					System.out.println("\n 5.Buscar personaje.");
					System.out.println("\n 6.Volver Atras.");
					menuPersonajes = read.nextInt();
					switch (menuPersonajes) {
					case 1:
						Personaje.listarPersonajes();
						System.out.println("Presione cualquier tecla para continuar.");
						Scanner c1 = new Scanner(System.in);
						c1.nextLine();
						break;
					case 2:
						Personaje.ColeccionPersonajes.add(Personaje.crearPersonaje());
						System.out.println("Presione cualquier tecla para continuar.");
						Scanner c2 = new Scanner(System.in);
						c2.nextLine();
						break;
					case 3:
						System.out.println("Introduce el ID del Personaje a Borrar.");
						Scanner c3 = new Scanner(System.in);
						int personajeABorrar = Integer.parseInt(c3.nextLine());
						Personaje.borrarPersonaje(Personaje.BuscarPersonaje(personajeABorrar));
						System.out.println("Presione cualquier tecla para continuar.");
						Scanner c4 = new Scanner(System.in);
						c4.nextLine();
						break;
					case 4:
						System.out.println("Introduce el Id del Personaje a Editar.");
						Scanner c5 = new Scanner(System.in);
						int PersonajeAEditar = Integer.parseInt(c5.nextLine());
						Personaje.EditarPersonaje(Personaje.BuscarPersonaje(PersonajeAEditar));
						System.out.println("Presione cualquier tecla para continuar.");
						Scanner c6 = new Scanner(System.in);
						c6.nextLine();
						break;
					case 5:
						System.out.println("Introduce el Id del Personaje a Buscar.");
						Scanner c7 = new Scanner(System.in);
						int PersonajeABuscar = Integer.parseInt(c7.nextLine());
						Personaje PersonajeEncontrado = Personaje.BuscarPersonaje(PersonajeABuscar);
						if (PersonajeEncontrado != null) {
							PersonajeEncontrado.MostrarInfo();
						} else {
							System.out.println("No s eha encontrado el Personaje");
						}
						System.out.println("Presione cualquier tecla para continuar.");
						Scanner c8 = new Scanner(System.in);
						c8.nextLine();
						break;
					default:
						System.out.println("Selecciono Volver Atras.");
					}

				} while (menuPersonajes < 6);
				break;
			case 3:
				int menuReinos = 0;
				do {
					System.out.println("\n\n***************************\n\n");
					System.out.println(" Menu Reinos");
					System.out.println(" Que va a Realizar...");
					System.out.println("\n 1.Listar Reinos.");
					System.out.println("\n 2.Crear Reino");
					System.out.println("\n 3.Borrar Reino.");
					System.out.println("\n 4.Editar Reino.");
					System.out.println("\n 5.Buscar Reino.");
					System.out.println("\n 6.A�adir Reinos Fronterizos.");
					System.out.println("\n 7.Eliminar Reinos Fronterizos.");
					System.out.println("\n 8.Listar Reinos Fronterizos.");
					System.out.println("\n 9.Volver Atras.");
					menuReinos = read.nextInt();
					switch (menuReinos) {
					case 1:
						Reino.listarReinos();
						System.out.println("Presione cualquier tecla para continuar.");
						Scanner c1 = new Scanner(System.in);
						c1.nextLine();
						break;
					case 2:
						Reino.ColeccionReinos.add(Reino.crearReino());
						System.out.println("Presione cualquier tecla para continuar.");
						Scanner c2 = new Scanner(System.in);
						c2.nextLine();
						break;
					case 3:
						System.out.println("Introduce el ID del Reino a Borrar.");
						Scanner c3 = new Scanner(System.in);
						int ReinoABorrar = Integer.parseInt(c3.nextLine());
						Reino.borrarReino(Reino.BuscarReino(ReinoABorrar));
						System.out.println("Presione cualquier tecla para continuar.");
						Scanner c4 = new Scanner(System.in);
						c4.nextLine();
						break;
					case 4:
						System.out.println("Introduce el Id del Reino a Editar.");
						Scanner c5 = new Scanner(System.in);
						int ReinoAEditar = Integer.parseInt(c5.nextLine());
						Reino.EditarReino(Reino.BuscarReino(ReinoAEditar));
						System.out.println("Presione cualquier tecla para continuar.");
						Scanner c6 = new Scanner(System.in);
						c6.nextLine();
						break;
					case 5:
						System.out.println("Introduce el Id del Reino a Buscar.");
						Scanner c7 = new Scanner(System.in);
						int ReinoABuscar = Integer.parseInt(c7.nextLine());
						Reino ReinoEncontrado = Reino.BuscarReino(ReinoABuscar);
						if (ReinoEncontrado != null) {
							ReinoEncontrado.MostrarInfo();
						} else {
							System.out.println("No s eha encontrado el Reino");
						}
						System.out.println("Presione cualquier tecla para continuar.");
						Scanner c8 = new Scanner(System.in);
						c8.nextLine();
						break;
					case 6:
						System.out.println("Introduce el Id del Reino al que quieres a�adir Reinos fronterizos.");
						Scanner c9 = new Scanner(System.in);
						int ReinoABuscar2 = Integer.parseInt(c9.nextLine());
						Reino ReinoEncontrado2 = Reino.BuscarReino(ReinoABuscar2);
						Reino.AnadirReinoFronterizo(ReinoEncontrado2);
						System.out.println("Presione cualquier tecla para continuar.");
						Scanner c10 = new Scanner(System.in);
						c10.nextLine();
						break;
					case 7:
						System.out.println("Introduce el Id del Reino al que quieres borrar Reinos fronterizos.");
						Scanner c11 = new Scanner(System.in);
						int ReinoABuscar3 = Integer.parseInt(c11.nextLine());
						Reino ReinoEncontrado3 = Reino.BuscarReino(ReinoABuscar3);
						Reino.BorrarFronterizo(ReinoEncontrado3);
						System.out.println("Presione cualquier tecla para continuar.");
						Scanner c12 = new Scanner(System.in);
						c12.nextLine();
						break;
					case 8:
						System.out.println("Introduce el Id del Reino del que quieres ver Reinos fronterizos.");
						Scanner c13 = new Scanner(System.in);
						int ReinoABuscar4 = Integer.parseInt(c13.nextLine());
						Reino ReinoEncontrado4 = Reino.BuscarReino(ReinoABuscar4);
						Reino.listarReinosFronterizos(ReinoEncontrado4);
						break;
					default:
						System.out.println("Selecciono Volver Atras.");
					}

				} while (menuReinos < 9);
				break;
			case 4:
				int menuEjercitos = 0;
				do {
					System.out.println("\n\n***************************\n\n");
					System.out.println(" Menu Ejercitos");
					System.out.println(" Que va a Realizar...");
					System.out.println("\n 1.Listar Ejercitos.");
					System.out.println("\n 2.Crear Ejercito nueva");
					System.out.println("\n 3.Borrar Ejercito.");
					System.out.println("\n 4.Editar Ejercito.");
					System.out.println("\n 5.Buscar Ejercito.");
					System.out.println("\n 6.A�adir Soldados.");
					System.out.println("\n 7.EliminarSoldados.");
					System.out.println("\n 8.Listar Soldados.");
					System.out.println("\n 9.Volver Atras.");
					menuEjercitos = read.nextInt();
					switch (menuEjercitos) {
					case 1:
						Ejercito.listarEjercitos();
						System.out.println("Presione cualquier tecla para continuar.");
						Scanner c1 = new Scanner(System.in);
						c1.nextLine();
						break;
					case 2:
						Ejercito.ColeccionEjercitos.add(Ejercito.crearEjercito());
						System.out.println("Presione cualquier tecla para continuar.");
						Scanner c2 = new Scanner(System.in);
						c2.nextLine();
						break;
					case 3:
						System.out.println("Introduce el ID del Ejercito a Borrar.");
						Scanner c3 = new Scanner(System.in);
						int EjercitoABorrar = Integer.parseInt(c3.nextLine());
						Ejercito.borrarEjercito(Ejercito.BuscarEjercito(EjercitoABorrar));
						System.out.println("Presione cualquier tecla para continuar.");
						Scanner c4 = new Scanner(System.in);
						c4.nextLine();
						break;
					case 4:
						System.out.println("Introduce el Id del Ejercito a Editar.");
						Scanner c5 = new Scanner(System.in);
						int EjercitoAEditar = Integer.parseInt(c5.nextLine());
						Ejercito.EditarEjercito(Ejercito.BuscarEjercito(EjercitoAEditar));
						System.out.println("Presione cualquier tecla para continuar.");
						Scanner c6 = new Scanner(System.in);
						c6.nextLine();
						break;
					case 5:
						System.out.println("Introduce el Id del Ejercito a Buscar.");
						Scanner c7 = new Scanner(System.in);
						int EjercitoABuscar = Integer.parseInt(c7.nextLine());
						Ejercito EjercitoEncontrado = Ejercito.BuscarEjercito(EjercitoABuscar);
						if (EjercitoEncontrado != null) {
							EjercitoEncontrado.MostrarInfo();
						} else {
							System.out.println("No s eha encontrado el Ejercito");
						}
						System.out.println("Presione cualquier tecla para continuar.");
						Scanner c8 = new Scanner(System.in);
						c8.nextLine();
						break;
					case 6:
						System.out.println("Introduce el Id del Ejercito al que quieres a�adir un Soldado.");
						Scanner c9 = new Scanner(System.in);
						int EjercitoABuscar2 = Integer.parseInt(c9.nextLine());
						Ejercito EjercitoEncontrado2 = Ejercito.BuscarEjercito(EjercitoABuscar2);
						Ejercito.AnadirSoldado(EjercitoEncontrado2);
						System.out.println("Presione cualquier tecla para continuar.");
						Scanner c10 = new Scanner(System.in);
						c10.nextLine();
						break;
					case 7:
						System.out.println("Introduce el Id del Ejercito al que quieres borrar Soldados.");
						Scanner c11 = new Scanner(System.in);
						int EjercitoABuscar3 = Integer.parseInt(c11.nextLine());
						Ejercito EjercitoEncontrado3 = Ejercito.BuscarEjercito(EjercitoABuscar3);
						Ejercito.BorrarSoldado(EjercitoEncontrado3);
						System.out.println("Presione cualquier tecla para continuar.");
						Scanner c12 = new Scanner(System.in);
						c12.nextLine();
						break;
					case 8:
						System.out.println("Introduce el Id del Ejercito del que quieres ver los soldados.");
						Scanner c13 = new Scanner(System.in);
						int EjercitoABuscar4 = Integer.parseInt(c13.nextLine());
						Ejercito EjercitoEncontrado4 = Ejercito.BuscarEjercito(EjercitoABuscar4);
						Ejercito.listarSoldadosEjercito(EjercitoEncontrado4);
						break;
					default:
						System.out.println("Selecciono Volver Atras.");
					}

				} while (menuEjercitos < 9);
				break;
			case 5:
				int menuBatallas = 0;
				do {
					System.out.println("\n\n***************************\n\n");
					System.out.println(" Menu Batalla");
					System.out.println(" Que va a Realizar...");
					System.out.println("\n 1.Listar Batallas.");
					System.out.println("\n 2.Crear batalla nueva");
					System.out.println("\n 3.Borrar Batalla.");
					System.out.println("\n 4.Editar Batalla.");
					System.out.println("\n 5.Buscar Batalla por Id.");
					System.out.println("\n 6.Buscar Batalla por fecha.");
					System.out.println("\n 7.Volver Atras.");
					menuBatallas = read.nextInt();
					switch (menuBatallas) {
					case 1:
						Batalla.listarBatallas();
						System.out.println("Presione cualquier tecla para continuar.");
						Scanner c1 = new Scanner(System.in);
						c1.nextLine();
						break;
					case 2:
						Batalla.ColeccionBatallas.add(Batalla.crearBatalla());
						System.out.println("Presione cualquier tecla para continuar.");
						Scanner c2 = new Scanner(System.in);
						c2.nextLine();
						break;
					case 3:
						System.out.println("Introduce el ID del Batalla a Borrar.");
						Scanner c3 = new Scanner(System.in);
						int BatallaABorrar = Integer.parseInt(c3.nextLine());
						Batalla.borrarBatalla(Batalla.BuscarBatalla(BatallaABorrar));
						System.out.println("Presione cualquier tecla para continuar.");
						Scanner c4 = new Scanner(System.in);
						c4.nextLine();
						break;
					case 4:
						System.out.println("Introduce el nombre del Batalla a Editar.");
						Scanner c5 = new Scanner(System.in);
						int BatallaAEditar = Integer.parseInt(c5.nextLine());
						Batalla.EditarBatalla(Batalla.BuscarBatalla(BatallaAEditar));
						System.out.println("Presione cualquier tecla para continuar.");
						Scanner c6 = new Scanner(System.in);
						c6.nextLine();
						break;
					case 5:
						System.out.println("Introduce el Id del Batalla a Buscar.");
						Scanner c7 = new Scanner(System.in);
						int BatallaABuscar = Integer.parseInt(c7.nextLine());
						Batalla BatallaEncontrado = Batalla.BuscarBatalla(BatallaABuscar);
						if (BatallaEncontrado != null) {
							BatallaEncontrado.MostrarInfo();
						} else {
							System.out.println("No s eha encontrado el Batalla");
						}
						System.out.println("Presione cualquier tecla para continuar.");
						Scanner c8 = new Scanner(System.in);
						c8.nextLine();
						break;
					case 6:
						System.out.println("Introduce la fecha de la  Batalla a Buscar.");

						System.out.println("� D�a? ");
						Scanner c9 = new Scanner(System.in);
						int day = Integer.parseInt(c9.nextLine());

						System.out.println("� Mes? ");
						Scanner c10 = new Scanner(System.in);
						int month = Integer.parseInt(c10.nextLine());

						System.out.println("� A�o? ");
						Scanner c11 = new Scanner(System.in);
						int year = Integer.parseInt(c11.nextLine());

						Batalla BatallaEncontrado2 = Batalla.BuscarBatalla2(day, month, year);
						if (BatallaEncontrado2 != null) {
							BatallaEncontrado2.MostrarInfo();
						} else {
							System.out.println("No s eha encontrado el Batalla");
						}
						System.out.println("Presione cualquier tecla para continuar.");
						Scanner c12 = new Scanner(System.in);
						c12.nextLine();
						break;
					default:
						System.out.println("Selecciono Volver Atras.");
					}

				} while (menuBatallas < 7);
				break;

			case 6:
				int menuDatos = 0;
				do {
					System.out.println("\n\n***************************\n\n");
					System.out.println(" Menu Datos");
					System.out.println(" Que va a Realizar...");
					System.out.println("\n 1.Importar Datos.");
					System.out.println("\n 2.Guardar Datos");
					System.out.println("\n 3.Volver Atras.");
					menuDatos = read.nextInt();
					switch (menuDatos) {
					case 1:
						GestionFicheros.guardarArchivo2();
						System.out.println("Presione cualquier tecla para continuar.");
						Scanner c1 = new Scanner(System.in);
						c1.nextLine();
						break;
					case 2:
						GestionFicheros.guardarArchivo();
						System.out.println("Presione cualquier tecla para continuar.");
						Scanner c2 = new Scanner(System.in);
						c2.nextLine();
						break;
					default:
						System.out.println("Selecciono Volver Atras.");
					}
				} while (menuDatos < 3);
				break;
			}

		} while (Seleccion < 6);

	}

}
