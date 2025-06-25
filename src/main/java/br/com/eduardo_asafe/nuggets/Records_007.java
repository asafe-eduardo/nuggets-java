package br.com.eduardo_asafe.nuggets;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
class TesteDTO {
    private String atributo1;
    private String atributo2;

    @Override
    public String toString() {
        return "Pessoa{" + "atributo1='" + atributo1 + '\'' + ", atributo2=" + atributo2 + '}';
    }
}
public class Records_007 {

    public record MeuDTO(String atributo1, String atributo2){}
    public static void main(String[] args) throws JsonProcessingException {
        ObjectMapper mapper = new ObjectMapper();

        System.out.println("===================== CLASSE CONCRETA ==================");
        TesteDTO testeDTO = new TesteDTO("valor1", "valor2");

        // Serializa objeto para JSON
        String json = mapper.writeValueAsString(testeDTO);
        System.out.println("JSON Serializado: " + json);

        // Desserializa JSON de volta para objeto
        TesteDTO testeDTO1 = mapper.readValue(json, TesteDTO.class);
        System.out.println("Objeto Desserializado: " + testeDTO1);

        System.out.println("");
        System.out.println("===================== RECORDS ==================");

        MeuDTO meuDTO = new MeuDTO("valor1", "valor2");

        // Serializa objeto para JSON
        String json2 = mapper.writeValueAsString(meuDTO);
        System.out.println("JSON Serializado: " + json2);

        // Desserializa JSON de volta para objeto
        MeuDTO meuDTO2 = mapper.readValue(json2, MeuDTO.class);
        System.out.println("Objeto Desserializado: " + meuDTO2);

        // APENAS JAVA 14+

    }

}
