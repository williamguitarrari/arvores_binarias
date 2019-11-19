package percurso;

public class ArvoreBin {
	
	 /**
     * ao inv�s deste enum, poderia ser usado um boolean
     */
    public enum ModoRL {
        esquerda, direita
    }
     
    private Node arvore;
 
    public Node getArvore() { return arvore; }
    public void setArvore(Node arvore) { this.arvore = arvore; }
     
    /**
     * 
     * @param raiz raiz da �rvore
     */
    public ArvoreBin(String raiz){
        setArvore(new Node(raiz));
    }
     
    /**
     * adiciona um novo n�
     * @param noPai nome do n� pai
     * @param nomeNo nome do novo n�
     * @param modo posi��o: direita / esquerda
     */
    public void AddNo(String noPai, String nomeNo, ModoRL modo){
        if (modo == ModoRL.direita) {
            AddNoDireita(noPai, nomeNo);
        } else if (modo == ModoRL.esquerda) {
            AddNoEsquerda(noPai, nomeNo);
        }
    }
     
    public void AddNoEsquerda(String noPai, String nomeNo){
        Node no = findNode(getArvore(), noPai);
        if (no == null) { return; }
        no.setEsquerda(new Node(nomeNo));
    }
     
    public void AddNoDireita(String noPai, String nomeNo){
        Node no = findNode(getArvore(), noPai);
        if (no == null) { return; }
        no.setDireita(new Node(nomeNo));
    }
     
    /**
     * A ideia n�o � criar uma �rvore bin�ria ordenada,
     * por isto a busca exaustiva pelos n�s.
 
     * A principal ideia � permitir criar qualquer tipo
     * de �rvore, com qualquer tipo de ordena��o.
     * @param no
     * @param nome
     * @return
     */
    private Node findNode(Node no, String nome){
        if (no == null || nome == null || nome.isEmpty()) { return null; }
        if (no.getNome().equals(nome)) { return no; }
        Node noesquerda = findNode(no.getEsquerda(), nome);
        if (noesquerda != null) { return noesquerda; }
        return findNode(no.getDireita(), nome);
    }
     
    /**
     * limpa a �rvore
     * @param raiz raiz da �rvore
     */
    public void Clear(String raiz){
        nullnodes(getArvore());
        setArvore(new Node(raiz));
    }
     
    /**
     * m�todo recursivo auxiliar para limpar a �rvore
     * @param no
     */
    private void nullnodes(Node no){
        if (no == null) { return; }
        nullnodes(no.getDireita());
        nullnodes(no.getEsquerda());
        no.setEsquerda(null); no.setDireita(null);
        no = null;
    }
     
    /**
     * RED
     * @return
     */
    public String PreOrdem(){
        if (getArvore() == null) { return ""; }
        return readPreOrdem(getArvore());
    }
     
    /**
     * RED
     * @param no
     * @return
     */
    private String readPreOrdem(Node no){
        if (no == null) {return "";}
        String rt = no.toString();
        if (no.getEsquerda() != null) {
            rt += (rt.isEmpty() ? "" : ",") + readPreOrdem(no.getEsquerda());
        }
        if (no.getDireita() != null) {
            rt += (rt.isEmpty() ? "" : ",") + readPreOrdem(no.getDireita());
        }
        return rt;
    }
     
    /**
     * ERD
     * @return
     */
    public String InOrdem(){
        if (getArvore() == null) { return ""; }
        return readInOrdem(getArvore());
    }
     
    /**
     * ERD
     * @param no
     * @return
     */
    private String readInOrdem(Node no){
        if (no == null) {return "";}
        String rt = "";
        if (no.getEsquerda() != null) {
            rt += (rt.isEmpty() ? "" : ",") + readInOrdem(no.getEsquerda());
        }
        rt += (rt.isEmpty() ? "" : ",") + no.toString();
        if (no.getDireita() != null) {
            rt += (rt.isEmpty() ? "" : ",") + readInOrdem(no.getDireita());
        }
        return rt;
    }
     
    /**
     * EDR
     * @return
     */
    public String PosOrdem(){
        if (getArvore() == null) { return ""; }
        return readPosOrdem(getArvore());
    }
     
    /**
     * EDR
     * @param no
     * @return
     */
    private String readPosOrdem(Node no){
        if (no == null) {return "";}
        String rt = "";
        if (no.getEsquerda() != null) {
            rt += (rt.isEmpty() ? "" : ",") + readPosOrdem(no.getEsquerda());
        }
        if (no.getDireita() != null) {
            rt += (rt.isEmpty() ? "" : ",") + readPosOrdem(no.getDireita());
        }
        rt += (rt.isEmpty() ? "" : ",") + no.toString();
        return rt;
    }

}
