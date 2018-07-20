package com.hulai.dushuren.common.log;

import android.util.Log;

//import org.dom4j.Document;
//import org.dom4j.DocumentException;
//import org.dom4j.io.OutputFormat;
//import org.dom4j.io.SAXReader;
//import org.dom4j.io.XMLWriter;

import java.io.IOException;
import java.io.StringReader;
import java.io.StringWriter;


/**
 * 作者：addison on 14/12/15 13:49
 * 邮箱：lsf@yonyou.com
 */
public class XmlLog {
//    public static void printXml(String tag, String xml, String headString) {
//
//        if (xml != null) {
//            xml = XmlLog.formatXML(xml);
//            xml = headString + "\n" + xml;
//        } else {
//            xml = headString + Elog.NULL_TIPS;
//        }
//
//        Elog.printLine(tag, true);
//        String[] lines = xml.split(Elog.LINE_SEPARATOR);
//        for (String line : lines) {
//            if (!Elog.isEmpty(line)) {
//                Log.d(tag, "║ " + line);
//            }
//        }
//        Elog.printLine(tag, false);
//    }
//
//    public static String formatXML(String inputXML) {
//        XMLWriter writer = null;
//        String requestXML = null;
//        try {
//            SAXReader reader = new SAXReader();
//            Document document = reader.read(new StringReader(inputXML));
//            StringWriter stringWriter = new StringWriter();
//            OutputFormat format = new OutputFormat(" ", true);
//            writer = new XMLWriter(stringWriter, format);
//            writer.write(document);
//            writer.flush();
//            requestXML = stringWriter.getBuffer().toString();
//        } catch (IOException e) {
//            return inputXML;
//        } catch (DocumentException e) {
//            return inputXML;
//        } finally {
//            if (writer != null) {
//                try {
//                    writer.close();
//                } catch (IOException e) {
//                    return inputXML;
//                }
//            }
//        }
//
//        return requestXML;
//    }
}
