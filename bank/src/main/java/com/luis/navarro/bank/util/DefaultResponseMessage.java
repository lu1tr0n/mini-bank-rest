package com.luis.navarro.bank.util;

public class DefaultResponseMessage {
	public static final String TIMEZONE = "America/El_Salvador";

	public final static String MESSAGE_CREATED_OK = "Client created";
	public final static String MESSAGE_NT_FOUND_ACCOUNT = "No se ha encontrado el numero de cuenta proporcionada.";
	public final static String MESSAGE_NT_NULL_NM_ACCOUNT = "El numero de cuenta es obligatorio.";
	public final static String MESSAGE_NT_NULL_ACCOUNT_TYPE = "El tipo de cuenta es obligatorio.";
	public final static String MESSAGE_EXISTS_ACCOUNT = "La cuenta que ha ingresado, ya existe en el sistema.";
	public final static String MESSAGE_LIST_ACCOUNT = "La lista de cuentas se encuentra vacía.";
	public final static String MESSAGE_NT_NULL_NAMES = "Los nombres de la persona son obligatorios.";
	public final static String MESSAGE_NT_NULL_SURNAMES = "Los apellidos de la persona son obligatorios.";
	public final static String MESSAGE_NT_NULL_GENDER = "El genero de la persona es obligatorio.";
	public final static String MESSAGE_SIZE_PERSON = "La edad de la persona debe ser mayor a cero.";
	public final static String MESSAGE_NT_NULL_AGE = "La edad de la persona es obligatoria.";
	public final static String MESSAGE_NT_NULL_ID = "El documento de identidad de la persona es obligatoria.";
	public final static String MESSAGE_FND_PERSON = "La persona con el documento ingresado, ya esta registado en el sistema.";
	public final static String MESSAGE_NT_FND_PERSON = "La persona con el documento ingresado, no se encuentra registrada o no existe.";
	public final static String MESSAGE_LIST_PERSON = "La lista de personas se encuentra vacía.";
	public final static String MESSAGE_EXISTS_CUSTOMER = "El cliente que intenta registrar, ya existe en el sistema.";
	public final static String MESSAGE_NT_FOUND_CUSTOMER = "No se ha encontrado el cliente.";
	public final static String MESSAGE_LIST_CUSTOMER = "La lista de clientes se encuentra vacía.";
	public final static String MESSAGE_LIST_ACC_MOV = "No se encontraron movimientos en el numero de cuenta proporcionado.";
	public final static String MESSAGE_NT_FOUND_MOV = "No se ha encontrado el movimiento consultado.";
	public final static String MESSAGE_LIST_MOV_ALL = "No se encontraron movimientos.";
	public final static String MESSAGE_ERR_MOUNT_MAX = "Cupo diario excedido.";
	public final static String MESSAGE_ERR_MOUNT_ZERO = "Saldo no disponible.";
	public final static String MESSAGE_ERR_MOUNT_GREATER_MOV = "El saldo de la cuenta es menor al monto a debitar.";
	public final static String MESSAGE_ERR_MOUNT_DIFFERENT = "El monto no puede actualizarse.";
	public final static String MESSAGE_ERR_ACCOUNT_DIFFERENT = "El numero de cuenta no puede actualizarse.";
	public final static String MESSAGE_ERR_MOV_ID = "El numero de movimiento es obligatorio.";
}
