 public Invoices read(File file) throws IOException {
        if (!file.exists()) {
            throw new IOException("file not found");
        }
        try {

            ObjectMapper jsonpath = new ObjectMapper();
            jsonpath.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);


            return jsonpath.readValue(file, Invoices.class);


        } catch (IOException e) {
            Invoices invoices = new Invoices();
            invoices.setFatture(new ArrayList<>());
            return invoices;
        }
    }