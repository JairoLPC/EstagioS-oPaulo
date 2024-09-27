
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.w3c.dom.Element;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.math.BigDecimal;
import java.math.RoundingMode;

    public class FaturamentoDistribuidoraXML {

        public static double arredondar(double valor) {

            BigDecimal bd = new BigDecimal(valor).setScale(2, RoundingMode.HALF_UP);
            return bd.doubleValue();
        }

        public static void main(String[] args) {



            try {
                File arquivoXML = new File("faturamento.xml");
                DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
                DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
                Document doc = dBuilder.parse(arquivoXML);

                doc.getDocumentElement().normalize();

                NodeList nodeList = doc.getElementsByTagName("dia");

                List<Double> faturamentosValidos = new ArrayList<>();

                for (int i = 0; i < nodeList.getLength(); i++) {
                    Element elemento = (Element) nodeList.item(i);
                    double valorFaturamento = Double.parseDouble(elemento.getAttribute("valor"));

                    if (valorFaturamento > 0) {
                        faturamentosValidos.add(valorFaturamento);
                    }
                }

                if (faturamentosValidos.isEmpty()) {
                    System.out.println("Nenhum faturamento registrado.");
                    return;
                }

                double menorFaturamento = faturamentosValidos.get(0);
                double maiorFaturamento = faturamentosValidos.get(0);
                double somaFaturamento = 0;

                for (double faturamento : faturamentosValidos) {
                    if (faturamento < menorFaturamento) {
                        menorFaturamento = faturamento;
                    }
                    if (faturamento > maiorFaturamento) {
                        maiorFaturamento = faturamento;
                    }
                    somaFaturamento += faturamento;
                }

                double mediaFaturamento = somaFaturamento / faturamentosValidos.size();

                int diasAcimaDaMedia = 0;
                for (double faturamento : faturamentosValidos) {
                    if (faturamento > mediaFaturamento) {
                        diasAcimaDaMedia++;
                    }
                }


                System.out.println("Menor faturamento: R$ " + arredondar(menorFaturamento));
                System.out.println("Maior faturamento: R$ " + arredondar(maiorFaturamento));
                System.out.println("Número de dias com faturamento acima da média: " + diasAcimaDaMedia);

            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
