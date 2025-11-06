public class ValidarCpfCnpj {

    // ============================
    // MÉTODO PARA VALIDAR CPF
    // ============================
    public static boolean validarCPF(String cpf) {
        if (cpf == null) return false;

        // Remove caracteres não numéricos
        cpf = cpf.replaceAll("\\D", "");

        // Verifica se tem 11 dígitos
        if (cpf.length() != 11) return false;

        // Verifica se todos os dígitos são iguais (ex: 11111111111)
        if (cpf.matches("(\\d)\\1{10}")) return false;

        try {
            // Cálculo do primeiro dígito verificador
            int soma = 0;
            for (int i = 0; i < 9; i++) {
                soma += (cpf.charAt(i) - '0') * (10 - i);
            }
            int resto = 11 - (soma % 11);
            int digito1 = (resto == 10 || resto == 11) ? 0 : resto;

            // Cálculo do segundo dígito verificador
            soma = 0;
            for (int i = 0; i < 10; i++) {
                soma += (cpf.charAt(i) - '0') * (11 - i);
            }
            resto = 11 - (soma % 11);
            int digito2 = (resto == 10 || resto == 11) ? 0 : resto;

            // Compara com os dígitos informados
            return digito1 == (cpf.charAt(9) - '0') && digito2 == (cpf.charAt(10) - '0');
        } catch (Exception e) {
            return false;
        }
    }

    // ============================
    // MÉTODO PARA VALIDAR CNPJ ALFANUMÉRICO
    // ============================
    public static boolean validarCNPJAlfanumerico(String cnpj) {
        if (cnpj == null) return false;

        // Remove caracteres não alfanuméricos
        cnpj = cnpj.replaceAll("[^A-Za-z0-9]", "").toUpperCase();

        // Deve ter 14 caracteres (12 + 2 DVs)
        if (cnpj.length() != 14) return false;

        try {
            String base = cnpj.substring(0, 12);
            String dvInformado = cnpj.substring(12, 14);

            // Calcula o primeiro DV
            int dv1 = calcularDV(base, new int[]{5,4,3,2,9,8,7,6,5,4,3,2});

            // Calcula o segundo DV (base + dv1)
            int dv2 = calcularDV(base + dv1, new int[]{6,5,4,3,2,9,8,7,6,5,4,3,2});

            String dvCalculado = "" + dv1 + dv2;

            return dvCalculado.equals(dvInformado);
        } catch (Exception e) {
            return false;
        }
    }

    // ============================
    // MÉTODO AUXILIAR PARA CALCULAR DV DO CNPJ ALFANUMÉRICO
    // ============================
    private static int calcularDV(String valor, int[] pesos) {
        int soma = 0;
        int len = valor.length();

        for (int i = 0; i < len; i++) {
            char c = valor.charAt(i);
            int val;

            if (Character.isDigit(c)) {
                val = c - '0';
            } else if (Character.isLetter(c)) {
                val = (int) c - 48; // conforme especificação SERPRO (A=17, B=18, etc.)
            } else {
                return -1; // caractere inválido
            }

            soma += val * pesos[i];
        }

        int resto = soma % 11;
        return (resto == 0 || resto == 1) ? 0 : (11 - resto);
    }

    // ============================
    // TESTE BÁSICO
    // ============================
//    public static void main(String[] args) {
//        System.out.println("=== TESTE DE CPF ===");
//        System.out.println("CPF válido? " + validarCPF("529.982.247-25"));   // true
//        System.out.println("CPF inválido? " + validarCPF("123.456.789-00")); // false
//
//        System.out.println("\n=== TESTE DE CNPJ ALFANUMÉRICO ===");
//        System.out.println("CNPJ alfanumérico válido? " + validarCNPJAlfanumerico("12ABC34501DE35")); // true (exemplo do SERPRO)
//        System.out.println("CNPJ alfanumérico inválido? " + validarCNPJAlfanumerico("12ABC34501DE99")); // false
//    }
}
