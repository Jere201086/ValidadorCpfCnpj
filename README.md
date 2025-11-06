# 🧮 ValidadorCpfCnpj
**Validador de CPF e CNPJ em Java para IBM BAW/BPM**

Este projeto fornece uma biblioteca simples e eficiente para validação de **CPF** e **CNPJ** em **Java**, podendo ser facilmente integrada ao **IBM Business Automation Workflow (BAW)** ou **IBM BPM** por meio de um *External Service*.

---

## 🚀 Funcionalidades

- ✅ Validação de **CPF** (com cálculo dos dígitos verificadores)  
- ✅ Validação de **CNPJ** (com cálculo dos dígitos verificadores)  
- ✅ Compatível com IBM BAW/BPM  
- ✅ Implementação simples com métodos estáticos

---

## 🧩 Como usar no IBM BAW

1. **Importe o JAR no BAW**  
   - Acesse a aba **Web File** do seu ambiente IBM BAW.  
   - Importe o arquivo:  
     ```
     validadorCpfCnpj-0.0.1.jar
     ```

2. **Crie um External Service**  
   - Vá em **External Implementations > External Services**.  
   - Configure o serviço conforme mostrado nas imagens abaixo.  

---

## 📸 Exemplo de Configuração

| Passo | Imagem |
|-------|--------|
| Criação do External Service | <img width="705" height="608" alt="image" src="https://github.com/user-attachments/assets/d85ef68d-c668-4548-918a-817b86ca2e36" /> |
| Configuração dos Métodos | <img width="704" height="609" alt="image" src="https://github.com/user-attachments/assets/22ad3428-b36b-4f46-af72-5b2c9002923e" />
 |

---

## 🧠 Exemplo de Uso no Código Java

```java
import br.com.sefa.validador.ValidadorCpfCnpj;

public class TesteValidador {
    public static void main(String[] args) {
        System.out.println(ValidadorCpfCnpj.validarCPF("12345678909"));  // true ou false
        System.out.println(ValidadorCpfCnpj.validarCNPJ("11222333000181"));  // true ou false
    }
}
```

## 📦 Versão
**Versão atual:** `0.0.1`

---

## 👨‍💻 Autor
**Jerônimo de Mello**  
Desenvolvedor | GFT Technologies SE  
🔗 [LinkedIn](https://www.linkedin.com/in/jer%C3%B4nimo-de-mello-393804124/)

---

## 📝 Licença
MIT.  
O uso em ambientes de produção deve ser avaliado e aprovado pela equipe responsável.

