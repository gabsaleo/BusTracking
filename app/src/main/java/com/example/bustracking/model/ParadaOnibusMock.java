package com.example.bustracking.model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class ParadaOnibusMock {

    /**
     *  Horário de referência da geração das informações
     */
    @SerializedName("hr")
    private String hr;

    /**
     * Representa um ponto de parada
     */
    @SerializedName("p")
    private P p;

    public String getHr() {
        return hr;
    }

    public void setHr(String hr) {
        this.hr = hr;
    }

    public P getP() {
        return p;
    }

    public void setP(P p) {
        this.p = p;
    }

    public class P {

        /**
         * código identificador da parada
         */
        @SerializedName("cp")
        private Integer cp;

        /**
         * Nome da parada
         */
        @SerializedName("np")
        private String np;

        /**
         *  Informação de latitude da localização do veículo
         */
        @SerializedName("py")
        private Double py;

        /**
         * Informação de longitude da localização do veículo
         */
        @SerializedName("px")
        private Double px;

        /**
         *  Relação de linhas localizadas
         */
        @SerializedName("l")
        private List<L> l = null;

        public Integer getCp() {
            return cp;
        }

        public void setCp(Integer cp) {
            this.cp = cp;
        }

        public String getNp() {
            return np;
        }

        public void setNp(String np) {
            this.np = np;
        }

        public Double getPy() {
            return py;
        }

        public void setPy(Double py) {
            this.py = py;
        }

        public Double getPx() {
            return px;
        }

        public void setPx(Double px) {
            this.px = px;
        }

        public List<L> getL() {
            return l;
        }

        public void setL(List<L> l) {
            this.l = l;
        }

    }

    public class L {

        /**
         * Letreiro completo
         */
        @SerializedName("c")
        private String c;

        /**
         * Código identificador da linha
         */
        @SerializedName("cl")
        private Integer cl;

        /**
         * Sentido de operação onde 1 significa de Terminal Principal para Terminal Secundário e 2
         * de Terminal Secundário para Terminal Principal
         */
        @SerializedName("sl")
        private Integer sl;

        /**
         * Letreiro de destino da linha
         */
        @SerializedName("lt0")
        private String lt0;

        /**
         * Letreiro de origem da linha
         */
        @SerializedName("lt1")
        private String lt1;

        /**
         * Quantidade de veículos localizados
         */
        @SerializedName("qv")
        private Integer qv;

        /**
         * Relação de veículos localizados
         */
        @SerializedName("vs")
        private List<V> vs = null;

        public String getC() {
            return c;
        }

        public void setC(String c) {
            this.c = c;
        }

        public Integer getCl() {
            return cl;
        }

        public void setCl(Integer cl) {
            this.cl = cl;
        }

        public Integer getSl() {
            return sl;
        }

        public void setSl(Integer sl) {
            this.sl = sl;
        }

        public String getLt0() {
            return lt0;
        }

        public void setLt0(String lt0) {
            this.lt0 = lt0;
        }

        public String getLt1() {
            return lt1;
        }

        public void setLt1(String lt1) {
            this.lt1 = lt1;
        }

        public Integer getQv() {
            return qv;
        }

        public void setQv(Integer qv) {
            this.qv = qv;
        }

        public List<V> getVs() {
            return vs;
        }

        public void setVs(List<V> vs) {
            this.vs = vs;
        }

    }

    public class V {

        /**
         * Prefixo do veículo
         */
        @SerializedName("p")
        private String p;

        /**
         * Horário previsto para chegada do veículo no ponto de parada relacionado
         */
        @SerializedName("t")
        private String t;

        /**
         *  Indica se o veículo é (true) ou não (false) acessível para pessoas com deficiência
         */
        @SerializedName("a")
        private Boolean a;

        /**
         * Indica o horário universal (UTC) em que a localização foi capturada. Essa informação
         * está no padrão ISO 8601
         */
        @SerializedName("ta")
        private String ta;

        /**
         * Informação de latitude da localização do veículo
         */
        @SerializedName("py")
        private Double py;

        /**
         * Informação de longitude da localização do veículo
         */
        @SerializedName("px")
        private Double px;

        public String getP() {
            return p;
        }

        public void setP(String p) {
            this.p = p;
        }

        public String getT() {
            return t;
        }

        public void setT(String t) {
            this.t = t;
        }

        public Boolean getA() {
            return a;
        }

        public void setA(Boolean a) {
            this.a = a;
        }

        public String getTa() {
            return ta;
        }

        public void setTa(String ta) {
            this.ta = ta;
        }

        public Double getPy() {
            return py;
        }

        public void setPy(Double py) {
            this.py = py;
        }

        public Double getPx() {
            return px;
        }

        public void setPx(Double px) {
            this.px = px;
        }

    }
}