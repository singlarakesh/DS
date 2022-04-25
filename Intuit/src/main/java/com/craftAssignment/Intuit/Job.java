package com.craftAssignment.Intuit;

public class Job implements Runnable {
	private String jobName;
	private JobPriority jobPriority;

	@Override
	public void run() {
		// TODO Auto-generated method stub
		System.out.println("JOB :" + jobName + "Priority:" + jobPriority);
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public String getJobName() {
		return jobName;
	}

	public void setJobName(String jobName) {
		this.jobName = jobName;
	}

	public JobPriority getJobPriority() {
		return jobPriority;
	}

	public void setJobPriority(JobPriority jobPriority) {
		this.jobPriority = jobPriority;
	}

	public Job(String jobName, JobPriority jobPriority) {
		super();
		this.jobName = jobName;
		this.jobPriority = jobPriority;
	}

}
