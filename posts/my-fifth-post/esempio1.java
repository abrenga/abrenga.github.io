private void htmlgenerate(Invoice invoice, String templatePath, String outPutPath) {
        File file = new File(templatePath);

    try {
            FileInputStream inputStream = new FileInputStream(file);
            String bytesInTheString = new String(inputStream.readAllBytes());

        if (bytesInTheString.contains("@DATE")) {
            bytesInTheString = bytesInTheString.replace("@DATE", invoice.getMonthly());
        }
        if (bytesInTheString.contains("@Total")) {
            bytesInTheString = bytesInTheString.replace("@Total", invoice.getAmount());
        }

            File fileOutput = new File(outPutPath);
            File directory = fileOutput.getParentFile();

        if (!directory.exists()) {
            directory.mkdirs();
        }

            FileWriter fileWriter = new FileWriter(fileOutput);
        fileWriter.write(bytesInTheString);
        fileWriter.close();

    } catch (Exception e) {
        System.out.print(e.getMessage());
    }

}
