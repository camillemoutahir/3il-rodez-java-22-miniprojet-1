package fr.ecole3il.rodez2023.perlin.terrain.elements;
/*Création de l'exception MauvaiseValeurException qui détermine un argument illégal */
public class MauvaiseValeurException extends IllegalArgumentException {
    public MauvaiseValeurException(String message) {
        super(message);
    }
}
