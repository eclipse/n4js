// Generated by N4JS transpiler; for copyright see original N4JS source file.

(function(System) {
	'use strict';
	System.register([], function($n4Export) {
		var TestFunctionType;
		TestFunctionType = function TestFunctionType(name, value) {
			this.name = name;
			this.value = value;
		};
		$n4Export('TestFunctionType', TestFunctionType);
		return {
			setters: [],
			execute: function() {
				$makeEnum(TestFunctionType, false, [
					[
						'BEFORE_ALL',
						'BEFORE_ALL'
					],
					[
						'BEFORE_TEST',
						'BEFORE_TEST'
					],
					[
						'AFTER_ALL',
						'AFTER_ALL'
					],
					[
						'AFTER_TEST',
						'AFTER_TEST'
					],
					[
						'TEST',
						'TEST'
					]
				], function(instanceProto, staticProto) {
					var metaClass = new N4EnumType({
						name: 'TestFunctionType',
						origin: 'org.eclipse.n4js.mangelhaft',
						fqn: 'org.eclipse.n4js.mangelhaft.types.TestFunctionType.TestFunctionType',
						n4superType: undefined,
						allImplementedInterfaces: [],
						ownedMembers: [],
						consumedMembers: [],
						annotations: []
					});
					return metaClass;
				});
			}
		};
	});
})(typeof module !== 'undefined' && module.exports ? require('n4js-node').System(require, module) : System);
//# sourceMappingURL=TestFunctionType.map
