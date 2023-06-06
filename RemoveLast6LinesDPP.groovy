// Import required classes
import java.util.Properties;
import java.io.InputStream;
import com.boomi.execution.ExecutionUtil

// Get input data stream
for( int i = 0; i < dataContext.getDataCount(); i++ ) {
    InputStream is = dataContext.getStream(i);
    Properties props = dataContext.getProperties(i);
    
    // Get input data from DPP
    data = ExecutionUtil.getDynamicProcessProperty("DPP_LastLinesRemoval_Input")
    
    // Split the data based on new lines
    lines = data.split('\n')
    
    // Remove the last 6 lines and join the data with new lines
    newContent = lines.take(lines.size() - 6).join('\n')
    
    // Set output data in DPP without persisting
    ExecutionUtil.setDynamicProcessProperty("DPP_LastLinesRemoval_Output", newContent, false)

    dataContext.storeStream(is, props);
}
