package com.fjmg;

import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.concurrent.atomic.AtomicInteger;

public class Main {
    final List<Herramienta> HERRAMIENTAS = Arrays.asList(new Herramienta("martillo"),new Herramienta("destornillador"),new Herramienta("taladro"));
    final List<Agente> AGENTES = List.of(new Agente("Ag1"),new Agente("Ag2"),new Agente("Ag3"));
    //Todo Crear las actividades y meterlas en while infinito. Añadir en ellas los Agentes necesarios y sus herramientas necesarias
    final List<Agente> Actividades = List.of(
                    new Actividad("A1 ",)
    );
    public static void main(String[] args) {
        

    }
    class Herramienta
    {
        private String tipo;
        private boolean uso;

        public Herramienta(String tipo) {
            this.tipo = tipo;
            this.uso = false;
        }

        public String getTipo() {
            return tipo;
        }

        public boolean isUso() {
            return uso;
        }
    }
    class Agente
    {
        private String nombre;
        public Agente(String nombre) {
            this.nombre = nombre;
        }

        public String getNombre() {
            return nombre;
        }
    }
    class Actividad implements Runnable
    {
        String nombre;
        final List<Herramienta> HERRAMIENTAS_NECESARIAS;
        final List<Agente> AGENTES_NECESARIOS;
        public Actividad(String nombre,List<Herramienta> herramientas,List<Agente> agentes)
        {
            this.nombre = nombre;
            HERRAMIENTAS_NECESARIAS = herramientas;
            AGENTES_NECESARIOS = agentes;
        }

        @Override
        public void run()
        {
            try {
                realizarActividad();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }

        public synchronized void realizarActividad() throws InterruptedException {
            System.out.println("La actividad" + nombre + "Esta preparando sus herramientas");
            synchronized (HERRAMIENTAS_NECESARIAS)
            {
                System.out.println("La actividad" + nombre + "Esta tiene sus herramientas");
                System.out.println("La actividad" + nombre + "Tiene las herramientas y agentes");
                synchronized (AGENTES_NECESARIOS)
                {
                   int tiempo =  new Random().nextInt(50,200);

                    System.out.println("La actividad" + nombre + "Tardara:" +tiempo+"ms");
                    Thread.sleep(tiempo);
                }

            }


        }
    }
}
