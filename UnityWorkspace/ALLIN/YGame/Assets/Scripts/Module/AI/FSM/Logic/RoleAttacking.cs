using System.Collections;
using UnityEngine;

namespace ShiHuanJue.FSM
{
	public class RoleAttacking : IState
	{
		public void Enter(params System.Object[] args)
		{
            Debug.Log("RoleAttacking Enter");
		}

        public void Exit(params System.Object[] args)
		{
            Debug.Log("RoleAttacking Exit");
		}

        public void Process(params System.Object[] args)
        {
            Debug.Log("RoleAttacking Process");

            //����Ǽ�������������ܸ���ʱ��������
        }
	}
}