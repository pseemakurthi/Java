/**
 * @author pseemakurthi
 * This is a sample program for Aggregation using Hadoop Mapreduce.
 */
package com.prasad.hadoop.employee;

import java.io.IOException;
import java.util.Map;
import java.util.StringTokenizer;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapred.lib.IdentityMapper;
import org.apache.hadoop.mapred.lib.IdentityReducer;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.mapreduce.Mapper;
import org.apache.hadoop.mapreduce.Partitioner;
import org.apache.hadoop.mapreduce.Reducer;
import org.apache.hadoop.mapreduce.Reducer.Context;
import org.apache.hadoop.mapreduce.lib.input.FileInputFormat;
import org.apache.hadoop.mapreduce.lib.input.NLineInputFormat;
import org.apache.hadoop.mapreduce.lib.input.SequenceFileRecordReader;
import org.apache.hadoop.mapreduce.lib.input.TextInputFormat;
import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat;
import org.apache.hadoop.mapreduce.lib.output.SequenceFileOutputFormat;
import org.apache.hadoop.mapreduce.lib.output.TextOutputFormat;
//import org.samples.mapreduce.training.counters.USERCOUNTER;


public class EmployeeData {
/**
 * 
 * @author pseemakurthi
 * mapper class
 */
   public static class MapEmployee extends
           Mapper<LongWritable, Text, Text, IntWritable> {

       // setup , map, run, cleanup
     /**
      * Map method takes the input (class as Text dataype) and splits each record using "," as delimiter
      * and emits Designation as Key with values {"manager","developer" and "trainee"} and values as IntWritable
      *  Input data types : Key which is a byte offset for each line  Values would be the actual datatype
      */
       public void map(LongWritable key, Text value, Context context)
               throws IOException, InterruptedException {
           String line = value.toString();
           String[] elements = line.split(",");


           Text tx = new Text(elements[2]);

           int i = Integer.parseInt(elements[4]);
           IntWritable it = new IntWritable(i);
           context.write(tx, it);
       }
   }
   
   /**
    * 
    * @author pseemakurthi
    *partitioner class
    * @param <K>
    * @param <V>
    */
   public static class DesignationPartitioner<K,V> extends Partitioner<K,V>{
   /**
    * partitioner: this class sets the number of partitioners required and this can be used and combiner as well	
    */
   	public int getPartition(K key,V value,int numReduceTasks){
   		
   		if(key.toString().equalsIgnoreCase("Manager"))
   			return 0;
   		else if(key.toString().equalsIgnoreCase("Developer"))
   			return 1;
   		else
   		  	return 2;
   	}
   	   	
   }
   /**
    * 
    * @author pseemakurthi
    *class reduce class
    */

   public static class ReduceEmployee extends
           Reducer<Text, IntWritable, Text, IntWritable> {

       // setup, reduce, run, cleanup
      /**
       * This is a sum reducer
       */
       public void reduce(Text key, Iterable<IntWritable> values,
                          Context context) throws IOException, InterruptedException {
           int sum = 0;
           for (IntWritable val : values) {
               sum += val.get();
           }
           context.write(key, new IntWritable(sum));
       }
   }        

   public static void main(String[] args) throws Exception {

       if (args.length != 2) {
           System.err.println("Insufficient args");
          System.exit(-1);
       }
       Configuration conf = new Configuration();

      // conf.set("mapred.job.tracker", "hdfs://localhost:50001");
      // conf.setInt("mapreduce.input.lineinputformat.linespermap", 5);
       Job job = new Job(conf, "Employee Record");

       job.setJarByClass(EmployeeData.class); // class conmtains mapper and
       // reducer class

       job.setMapOutputKeyClass(Text.class); // map output key class
       job.setMapOutputValueClass(IntWritable.class);// map output value class
       job.setOutputKeyClass(Text.class); // output key type in reducer
       job.setOutputValueClass(IntWritable.class);// output value type in
       // reducer

       job.setMapperClass(MapEmployee.class);
       //job.setMapperClass(Mapper.class);
       
       job.setReducerClass(ReduceEmployee.class);
	   //job.setCombinerClass(ReduceEmployee.class);
      //job.setNumReduceTasks(3);
      //job.setPartitionerClass(DesignationPartitioner.class);
       
       //job.setInputFormatClass(NLineInputFormat.class); // default -- inputkey
       job.setInputFormatClass(TextInputFormat.class);
       
       job.setOutputFormatClass(TextOutputFormat.class);
       //job.setOutputFormatClass(SequenceFileOutputFormat.class);

       FileInputFormat.addInputPath(job, new Path(args[0]));
       FileOutputFormat.setOutputPath(job, new Path(args[1]));

       job.waitForCompletion(true);

   }

}
