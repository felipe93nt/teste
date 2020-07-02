package br.com.bradesco.web.ricc.utils;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import br.com.bradesco.web.ricc.exception.RiccException;

public final class SecurityScan {

	public final String VAZIO = "";
	public final String GET = "get";
	public final String SET = "set";
	public final String ESPACO = " ";

	private String REGEX_CARACTER = "[\\{ \\} \\( \\) \\* \\< \\> \\= \\[ \\] \\+ \\| \\']";

	private static SecurityScan instance = null;

	/**
	 * Construtor privado da classe SiteUtil.
	 */
	private SecurityScan() {

	}

	public static SecurityScan getInstance() {
		if (instance == null) {
			instance = new SecurityScan();
		}
		return instance;
	}

	/**
	 * Nome: removeCaracterObjeto
	 *
	 * Ler o objeto e limpa todos os atributos do mesmo
	 *
	 * Remove Caracter Objeto.
	 *
	 * @return valor do atributo 'ob'
	 *
	 * @see
	 */
	public Object removeCaracterObjeto(Object ob) {

		Method[] metodos = ob.getClass().getMethods();
		String name = null;
		Object valorRetornoMetodo = null;
		String valorAlterar = null;

		// PERCORRE TODOS OS MÉTODOS DA CLASSE PASSADA COMO PARÂMETRO NO MÉTODO
		// removeCaracterObjeto
		for (Method metodo : metodos) {

			// VERIFICA SE O MÉTODO COMEÇA COM A PALAVRA GET E SE O MÉTODO NÃO
			// RECEBE PARÂMETROS
			if (metodo.getName().startsWith(GET)
					&& metodo.getParameterTypes().length == 0) {

				name = metodo.getName().substring(3, metodo.getName().length());

				try {
					valorRetornoMetodo = metodo.invoke(ob, new Object[] {});
				} catch (IllegalAccessException e) {
					throw new RiccException(e.getMessage(), e);
				} catch (IllegalArgumentException e) {
					throw new RiccException(e.getMessage(), e);
				} catch (InvocationTargetException e) {
					throw new RiccException(e.getMessage(), e);
				}

				// VERIFICA SE valorRetornoMetodo É DIFERENTE DE NULO E UMA
				// INSTÂNCIA DE STRING
				if (valorRetornoMetodo != null
						&& !valorRetornoMetodo.equals(VAZIO)
						&& valorRetornoMetodo instanceof String) {

					valorAlterar = removeCaracter(valorRetornoMetodo.toString());

					Method methodSet = null;

					try {

						for(Method item: metodos){

							if(item.getName().equals(SET + name)){
								methodSet = item;
								break;
							}
						}

					} catch (SecurityException e) {
						throw new RiccException(e.getMessage(), e);
					}

					try {

						methodSet.invoke(ob, valorAlterar);

					} catch (IllegalAccessException e) {
						throw new RiccException(e.getMessage(), e);
					} catch (IllegalArgumentException e) {
						throw new RiccException(e.getMessage(), e);
					} catch (InvocationTargetException e) {
						throw new RiccException(e.getMessage(), e);
					}
				}
			}
		}
		return ob;
	}

	/**
	 * Nome: removeCaracter
	 *
	 * Remove Caracter.
	 *
	 * @return valor do atributo 'campo'
	 *
	 * @see
	 */
	public String removeCaracter(String campo) {

		Pattern p = Pattern.compile(REGEX_CARACTER);

		StringBuffer sb = new StringBuffer();

		if (campo != null && !campo.equals(VAZIO)) {

			Matcher m = p.matcher(campo);

			while (m.find()) {
				m.appendReplacement(sb, ESPACO);
			}

			m.appendTail(sb);
		}

		return sb.toString();
	}

}
