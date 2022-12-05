package com.backstreetbrogrammer.chapter03_sparkfirstprogram;

import org.apache.spark.SparkConf;
import org.apache.spark.api.java.JavaSparkContext;

import java.util.List;

public class SparkFirstProgram {

    public static void main(String[] args) {
        final var conf = new SparkConf().setAppName("SparkFirstProgram").setMaster("local[*]");
        final var sc = new JavaSparkContext(conf);

        final var data = List.of(165, 254, 124656, 356838, 64836);
        final var myRdd = sc.parallelize(data);

        final var max = myRdd.reduce(Integer::max);
        System.out.println(max);

        sc.close();
    }

}
