package com.chatgpt;

import com.theokanning.openai.completion.CompletionRequest;
import com.theokanning.openai.service.OpenAiService;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        OpenAiService service = new OpenAiService("API_KEY");

        var leitura = new Scanner(System.in);
        System.out.println("Digite: ");
        var pergunta = leitura.nextLine();

        CompletionRequest request = CompletionRequest.builder()
                .model("text-davinci-003")
                .prompt(pergunta)
                .maxTokens(2800)
                .build();

        var resposta = service.createCompletion(request);

        System.out.println(resposta.getChoices().get(0).getText());
    }
}
